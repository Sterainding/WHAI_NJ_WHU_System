package cn.iocoder.yudao.module.system.service.jzldrshgx;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrshgx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrshgx.JzldrshgxDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrshgx.JzldrshgxMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 社会关系数据 Service 实现类
 *
 * @author 芋道源码
 */
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
@Service
@Validated
public class JzldrshgxServiceImpl implements JzldrshgxService {

    @Resource
    private JzldrshgxMapper jzldrshgxMapper;

    @Override
    public String createJzldrshgx(JzldrshgxSaveReqVO createReqVO) {
        // 插入
        JzldrshgxDO jzldrshgx = BeanUtils.toBean(createReqVO, JzldrshgxDO.class);
        jzldrshgxMapper.insert(jzldrshgx);
        // 返回
        return jzldrshgx.getId();
    }

    @Override
    public void updateJzldrshgx(JzldrshgxSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrshgxExists(updateReqVO.getId());
        // 更新
        JzldrshgxDO updateObj = BeanUtils.toBean(updateReqVO, JzldrshgxDO.class);
        jzldrshgxMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrshgx(String id) {
        // 校验存在
        validateJzldrshgxExists(id);
        // 删除
        jzldrshgxMapper.deleteById(id);
    }

    private void validateJzldrshgxExists(String id) {
        if (jzldrshgxMapper.selectById(id) == null) {
            throw exception(JZLDRSHGX_NOT_EXISTS);
        }
    }

    @Override
    public JzldrshgxDO getJzldrshgx(String id) {
        return jzldrshgxMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrshgxDO> getJzldrshgxPage(JzldrshgxPageReqVO pageReqVO) {
        return jzldrshgxMapper.selectPage(pageReqVO);
    }

}