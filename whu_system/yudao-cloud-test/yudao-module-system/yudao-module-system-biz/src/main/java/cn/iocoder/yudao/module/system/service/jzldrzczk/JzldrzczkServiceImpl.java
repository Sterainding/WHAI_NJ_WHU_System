package cn.iocoder.yudao.module.system.service.jzldrzczk;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrzczk.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrzczk.JzldrzczkDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrzczk.JzldrzczkMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 资产状况数据 Service 实现类
 *
 * @author 芋道源码
 */
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
@Service
@Validated
public class JzldrzczkServiceImpl implements JzldrzczkService {

    @Resource
    private JzldrzczkMapper jzldrzczkMapper;

    @Override
    public String createJzldrzczk(JzldrzczkSaveReqVO createReqVO) {
        // 插入
        JzldrzczkDO jzldrzczk = BeanUtils.toBean(createReqVO, JzldrzczkDO.class);
        jzldrzczkMapper.insert(jzldrzczk);
        // 返回
        return jzldrzczk.getId();
    }

    @Override
    public void updateJzldrzczk(JzldrzczkSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrzczkExists(updateReqVO.getId());
        // 更新
        JzldrzczkDO updateObj = BeanUtils.toBean(updateReqVO, JzldrzczkDO.class);
        jzldrzczkMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrzczk(String id) {
        // 校验存在
        validateJzldrzczkExists(id);
        // 删除
        jzldrzczkMapper.deleteById(id);
    }

    private void validateJzldrzczkExists(String id) {
        if (jzldrzczkMapper.selectById(id) == null) {
            throw exception(JZLDRZCZK_NOT_EXISTS);
        }
    }

    @Override
    public JzldrzczkDO getJzldrzczk(String id) {
        return jzldrzczkMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrzczkDO> getJzldrzczkPage(JzldrzczkPageReqVO pageReqVO) {
        return jzldrzczkMapper.selectPage(pageReqVO);
    }

}