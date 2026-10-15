package cn.iocoder.yudao.module.system.service.jzldrdpbj;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrdpbj.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrdpbj.JzldrdpbjDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrdpbj.JzldrdpbjMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 党派背景数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldrdpbjServiceImpl implements JzldrdpbjService {

    @Resource
    private JzldrdpbjMapper jzldrdpbjMapper;

    @Override
    public String createJzldrdpbj(JzldrdpbjSaveReqVO createReqVO) {
        // 插入
        JzldrdpbjDO jzldrdpbj = BeanUtils.toBean(createReqVO, JzldrdpbjDO.class);
        jzldrdpbjMapper.insert(jzldrdpbj);
        // 返回
        return jzldrdpbj.getId();
    }

    @Override
    public void updateJzldrdpbj(JzldrdpbjSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrdpbjExists(updateReqVO.getId());
        // 更新
        JzldrdpbjDO updateObj = BeanUtils.toBean(updateReqVO, JzldrdpbjDO.class);
        jzldrdpbjMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrdpbj(String id) {
        // 校验存在
        validateJzldrdpbjExists(id);
        // 删除
        jzldrdpbjMapper.deleteById(id);
    }

    private void validateJzldrdpbjExists(String id) {
        if (jzldrdpbjMapper.selectById(id) == null) {
            throw exception(JZLDRDPBJ_NOT_EXISTS);
        }
    }

    @Override
    public JzldrdpbjDO getJzldrdpbj(String id) {
        return jzldrdpbjMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrdpbjDO> getJzldrdpbjPage(JzldrdpbjPageReqVO pageReqVO) {
        return jzldrdpbjMapper.selectPage(pageReqVO);
    }

}