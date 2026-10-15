package cn.iocoder.yudao.module.system.service.jzldrrzjl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrzjl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrzjl.JzldrrzjlDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrrzjl.JzldrrzjlMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 任职经历数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldrrzjlServiceImpl implements JzldrrzjlService {

    @Resource
    private JzldrrzjlMapper jzldrrzjlMapper;

    @Override
    public String createJzldrrzjl(JzldrrzjlSaveReqVO createReqVO) {
        // 插入
        JzldrrzjlDO jzldrrzjl = BeanUtils.toBean(createReqVO, JzldrrzjlDO.class);
        jzldrrzjlMapper.insert(jzldrrzjl);
        // 返回
        return jzldrrzjl.getId();
    }

    @Override
    public void updateJzldrrzjl(JzldrrzjlSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrrzjlExists(updateReqVO.getId());
        // 更新
        JzldrrzjlDO updateObj = BeanUtils.toBean(updateReqVO, JzldrrzjlDO.class);
        jzldrrzjlMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrrzjl(String id) {
        // 校验存在
        validateJzldrrzjlExists(id);
        // 删除
        jzldrrzjlMapper.deleteById(id);
    }

    private void validateJzldrrzjlExists(String id) {
        if (jzldrrzjlMapper.selectById(id) == null) {
            throw exception(JZLDRRZJL_NOT_EXISTS);
        }
    }

    @Override
    public JzldrrzjlDO getJzldrrzjl(String id) {
        return jzldrrzjlMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrrzjlDO> getJzldrrzjlPage(JzldrrzjlPageReqVO pageReqVO) {
        return jzldrrzjlMapper.selectPage(pageReqVO);
    }

}