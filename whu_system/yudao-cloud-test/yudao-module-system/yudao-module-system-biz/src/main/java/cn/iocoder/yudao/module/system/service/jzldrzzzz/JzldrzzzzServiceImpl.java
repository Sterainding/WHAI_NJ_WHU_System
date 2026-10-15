package cn.iocoder.yudao.module.system.service.jzldrzzzz;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrzzzz.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrzzzz.JzldrzzzzDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrzzzz.JzldrzzzzMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 政治主张数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldrzzzzServiceImpl implements JzldrzzzzService {

    @Resource
    private JzldrzzzzMapper jzldrzzzzMapper;

    @Override
    public String createJzldrzzzz(JzldrzzzzSaveReqVO createReqVO) {
        // 插入
        JzldrzzzzDO jzldrzzzz = BeanUtils.toBean(createReqVO, JzldrzzzzDO.class);
        jzldrzzzzMapper.insert(jzldrzzzz);
        // 返回
        return jzldrzzzz.getId();
    }

    @Override
    public void updateJzldrzzzz(JzldrzzzzSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrzzzzExists(updateReqVO.getId());
        // 更新
        JzldrzzzzDO updateObj = BeanUtils.toBean(updateReqVO, JzldrzzzzDO.class);
        jzldrzzzzMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrzzzz(String id) {
        // 校验存在
        validateJzldrzzzzExists(id);
        // 删除
        jzldrzzzzMapper.deleteById(id);
    }

    private void validateJzldrzzzzExists(String id) {
        if (jzldrzzzzMapper.selectById(id) == null) {
            throw exception(JZLDRZZZZ_NOT_EXISTS);
        }
    }

    @Override
    public JzldrzzzzDO getJzldrzzzz(String id) {
        return jzldrzzzzMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrzzzzDO> getJzldrzzzzPage(JzldrzzzzPageReqVO pageReqVO) {
        return jzldrzzzzMapper.selectPage(pageReqVO);
    }

}