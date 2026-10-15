package cn.iocoder.yudao.module.system.service.jzldrrwyl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwyl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwyl.JzldrrwylDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrrwyl.JzldrrwylMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")

/**
 * 人物言论 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldrrwylServiceImpl implements JzldrrwylService {

    @Resource
    private JzldrrwylMapper jzldrrwylMapper;

    @Override
    public String createJzldrrwyl(JzldrrwylSaveReqVO createReqVO) {
        // 插入
        JzldrrwylDO jzldrrwyl = BeanUtils.toBean(createReqVO, JzldrrwylDO.class);
        jzldrrwylMapper.insert(jzldrrwyl);
        // 返回
        return jzldrrwyl.getId();
    }

    @Override
    public void updateJzldrrwyl(JzldrrwylSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrrwylExists(updateReqVO.getId());
        // 更新
        JzldrrwylDO updateObj = BeanUtils.toBean(updateReqVO, JzldrrwylDO.class);
        jzldrrwylMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrrwyl(String id) {
        // 校验存在
        validateJzldrrwylExists(id);
        // 删除
        jzldrrwylMapper.deleteById(id);
    }

    private void validateJzldrrwylExists(String id) {
        if (jzldrrwylMapper.selectById(id) == null) {
            throw exception(JZLDRRWYL_NOT_EXISTS);
        }
    }

    @Override
    public JzldrrwylDO getJzldrrwyl(String id) {
        return jzldrrwylMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrrwylDO> getJzldrrwylPage(JzldrrwylPageReqVO pageReqVO) {
        return jzldrrwylMapper.selectPage(pageReqVO);
    }

}