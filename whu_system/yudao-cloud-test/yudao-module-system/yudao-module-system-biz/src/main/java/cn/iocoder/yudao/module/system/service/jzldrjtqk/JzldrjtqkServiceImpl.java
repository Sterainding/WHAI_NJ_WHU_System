package cn.iocoder.yudao.module.system.service.jzldrjtqk;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrjtqk.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrjtqk.JzldrjtqkDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrjtqk.JzldrjtqkMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 家庭情况数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated

public class JzldrjtqkServiceImpl implements JzldrjtqkService {

    @Resource
    private JzldrjtqkMapper jzldrjtqkMapper;

    @Override
    public String createJzldrjtqk(JzldrjtqkSaveReqVO createReqVO) {
        // 插入
        JzldrjtqkDO jzldrjtqk = BeanUtils.toBean(createReqVO, JzldrjtqkDO.class);
        jzldrjtqkMapper.insert(jzldrjtqk);
        // 返回
        return jzldrjtqk.getId();
    }

    @Override
    public void updateJzldrjtqk(JzldrjtqkSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrjtqkExists(updateReqVO.getId());
        // 更新
        JzldrjtqkDO updateObj = BeanUtils.toBean(updateReqVO, JzldrjtqkDO.class);
        jzldrjtqkMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrjtqk(String id) {
        // 校验存在
        validateJzldrjtqkExists(id);
        // 删除
        jzldrjtqkMapper.deleteById(id);
    }

    private void validateJzldrjtqkExists(String id) {
        if (jzldrjtqkMapper.selectById(id) == null) {
            throw exception(JZLDRJTQK_NOT_EXISTS);
        }
    }

    @Override
    public JzldrjtqkDO getJzldrjtqk(String id) {
        return jzldrjtqkMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrjtqkDO> getJzldrjtqkPage(JzldrjtqkPageReqVO pageReqVO) {
        return jzldrjtqkMapper.selectPage(pageReqVO);
    }

}