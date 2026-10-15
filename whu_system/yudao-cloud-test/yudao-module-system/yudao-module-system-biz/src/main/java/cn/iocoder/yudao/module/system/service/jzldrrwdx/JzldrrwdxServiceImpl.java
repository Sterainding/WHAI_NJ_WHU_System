package cn.iocoder.yudao.module.system.service.jzldrrwdx;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwdx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwdx.JzldrrwdxDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrrwdx.JzldrrwdxMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 人物动向数据 Service 实现类
 *
 * @author 芋道源码
 */
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
@Service
@Validated
public class JzldrrwdxServiceImpl implements JzldrrwdxService {

    @Resource
    private JzldrrwdxMapper jzldrrwdxMapper;

    @Override
    public String createJzldrrwdx(JzldrrwdxSaveReqVO createReqVO) {
        // 插入
        JzldrrwdxDO jzldrrwdx = BeanUtils.toBean(createReqVO, JzldrrwdxDO.class);
        jzldrrwdxMapper.insert(jzldrrwdx);
        // 返回
        return jzldrrwdx.getId();
    }

    @Override
    public void updateJzldrrwdx(JzldrrwdxSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrrwdxExists(updateReqVO.getId());
        // 更新
        JzldrrwdxDO updateObj = BeanUtils.toBean(updateReqVO, JzldrrwdxDO.class);
        jzldrrwdxMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrrwdx(String id) {
        // 校验存在
        validateJzldrrwdxExists(id);
        // 删除
        jzldrrwdxMapper.deleteById(id);
    }

    private void validateJzldrrwdxExists(String id) {
        if (jzldrrwdxMapper.selectById(id) == null) {
            throw exception(JZLDRRWDX_NOT_EXISTS);
        }
    }

    @Override
    public JzldrrwdxDO getJzldrrwdx(String id) {
        return jzldrrwdxMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrrwdxDO> getJzldrrwdxPage(JzldrrwdxPageReqVO pageReqVO) {
        return jzldrrwdxMapper.selectPage(pageReqVO);
    }

}