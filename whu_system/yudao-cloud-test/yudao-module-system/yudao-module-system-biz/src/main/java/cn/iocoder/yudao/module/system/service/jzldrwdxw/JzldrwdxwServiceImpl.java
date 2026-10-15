package cn.iocoder.yudao.module.system.service.jzldrwdxw;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrwdxw.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrwdxw.JzldrwdxwDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrwdxw.JzldrwdxwMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 污点新闻数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldrwdxwServiceImpl implements JzldrwdxwService {

    @Resource
    private JzldrwdxwMapper jzldrwdxwMapper;

    @Override
    public String createJzldrwdxw(JzldrwdxwSaveReqVO createReqVO) {
        // 插入
        JzldrwdxwDO jzldrwdxw = BeanUtils.toBean(createReqVO, JzldrwdxwDO.class);
        jzldrwdxwMapper.insert(jzldrwdxw);
        // 返回
        return jzldrwdxw.getId();
    }

    @Override
    public void updateJzldrwdxw(JzldrwdxwSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrwdxwExists(updateReqVO.getId());
        // 更新
        JzldrwdxwDO updateObj = BeanUtils.toBean(updateReqVO, JzldrwdxwDO.class);
        jzldrwdxwMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrwdxw(String id) {
        // 校验存在
        validateJzldrwdxwExists(id);
        // 删除
        jzldrwdxwMapper.deleteById(id);
    }

    private void validateJzldrwdxwExists(String id) {
        if (jzldrwdxwMapper.selectById(id) == null) {
            throw exception(JZLDRWDXW_NOT_EXISTS);
        }
    }

    @Override
    public JzldrwdxwDO getJzldrwdxw(String id) {
        return jzldrwdxwMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrwdxwDO> getJzldrwdxwPage(JzldrwdxwPageReqVO pageReqVO) {
        return jzldrwdxwMapper.selectPage(pageReqVO);
    }

}