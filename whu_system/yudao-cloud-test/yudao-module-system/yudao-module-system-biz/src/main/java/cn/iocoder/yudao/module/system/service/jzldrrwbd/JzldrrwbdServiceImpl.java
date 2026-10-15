package cn.iocoder.yudao.module.system.service.jzldrrwbd;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwbd.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwbd.JzldrrwbdDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrrwbd.JzldrrwbdMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 人物报道数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldrrwbdServiceImpl implements JzldrrwbdService {

    @Resource
    private JzldrrwbdMapper jzldrrwbdMapper;

    @Override
    public String createJzldrrwbd(JzldrrwbdSaveReqVO createReqVO) {
        // 插入
        JzldrrwbdDO jzldrrwbd = BeanUtils.toBean(createReqVO, JzldrrwbdDO.class);
        jzldrrwbdMapper.insert(jzldrrwbd);
        // 返回
        return jzldrrwbd.getId();
    }

    @Override
    public void updateJzldrrwbd(JzldrrwbdSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrrwbdExists(updateReqVO.getId());
        // 更新
        JzldrrwbdDO updateObj = BeanUtils.toBean(updateReqVO, JzldrrwbdDO.class);
        jzldrrwbdMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrrwbd(String id) {
        // 校验存在
        validateJzldrrwbdExists(id);
        // 删除
        jzldrrwbdMapper.deleteById(id);
    }

    private void validateJzldrrwbdExists(String id) {
        if (jzldrrwbdMapper.selectById(id) == null) {
            throw exception(JZLDRRWBD_NOT_EXISTS);
        }
    }

    @Override
    public JzldrrwbdDO getJzldrrwbd(String id) {
        return jzldrrwbdMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrrwbdDO> getJzldrrwbdPage(JzldrrwbdPageReqVO pageReqVO) {
        return jzldrrwbdMapper.selectPage(pageReqVO);
    }

}