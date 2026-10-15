package cn.iocoder.yudao.module.system.service.jzldrjbxx;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrjbxx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrjbxx.JzldrjbxxDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrjbxx.JzldrjbxxMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 基本信息数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated

public class JzldrjbxxServiceImpl implements JzldrjbxxService {

    @Resource
    private JzldrjbxxMapper jzldrjbxxMapper;

    @Override
    public String createJzldrjbxx(JzldrjbxxSaveReqVO createReqVO) {
        // 插入
        JzldrjbxxDO jzldrjbxx = BeanUtils.toBean(createReqVO, JzldrjbxxDO.class);
        jzldrjbxxMapper.insert(jzldrjbxx);
        // 返回
        return jzldrjbxx.getId();
    }

    @Override
    public void updateJzldrjbxx(JzldrjbxxSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrjbxxExists(updateReqVO.getId());
        // 更新
        JzldrjbxxDO updateObj = BeanUtils.toBean(updateReqVO, JzldrjbxxDO.class);
        jzldrjbxxMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrjbxx(String id) {
        // 校验存在
        validateJzldrjbxxExists(id);
        // 删除
        jzldrjbxxMapper.deleteById(id);
    }

    private void validateJzldrjbxxExists(String id) {
        if (jzldrjbxxMapper.selectById(id) == null) {
            throw exception(JZLDRJBXX_NOT_EXISTS);
        }
    }

    @Override
    public JzldrjbxxDO getJzldrjbxx(String id) {
        return jzldrjbxxMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrjbxxDO> getJzldrjbxxPage(JzldrjbxxPageReqVO pageReqVO) {
        return jzldrjbxxMapper.selectPage(pageReqVO);
    }

}