package cn.iocoder.yudao.module.system.service.Jzldrzytc;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.Jzldrzytc.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.Jzldrzytc.JzldrzytcDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.Jzldrzytc.JzldrzytcMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 专业特长数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldrzytcServiceImpl implements JzldrzytcService {

    @Resource
    private JzldrzytcMapper jzldrzytcMapper;

    @Override
    public String createJzldrzytc(JzldrzytcSaveReqVO createReqVO) {
        // 插入
        JzldrzytcDO jzldrzytc = BeanUtils.toBean(createReqVO, JzldrzytcDO.class);
        jzldrzytcMapper.insert(jzldrzytc);
        // 返回
        return jzldrzytc.getId();
    }

    @Override
    public void updateJzldrzytc(JzldrzytcSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrzytcExists(updateReqVO.getId());
        // 更新
        JzldrzytcDO updateObj = BeanUtils.toBean(updateReqVO, JzldrzytcDO.class);
        jzldrzytcMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrzytc(String id) {
        // 校验存在
        validateJzldrzytcExists(id);
        // 删除
        jzldrzytcMapper.deleteById(id);
    }

    private void validateJzldrzytcExists(String id) {
        if (jzldrzytcMapper.selectById(id) == null) {
            throw exception(JZLDRZYTC_NOT_EXISTS);
        }
    }

    @Override
    public JzldrzytcDO getJzldrzytc(String id) {
        return jzldrzytcMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrzytcDO> getJzldrzytcPage(JzldrzytcPageReqVO pageReqVO) {
        return jzldrzytcMapper.selectPage(pageReqVO);
    }

}