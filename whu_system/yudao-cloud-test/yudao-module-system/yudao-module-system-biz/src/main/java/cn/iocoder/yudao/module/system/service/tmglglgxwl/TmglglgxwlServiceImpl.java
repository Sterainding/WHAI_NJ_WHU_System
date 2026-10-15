package cn.iocoder.yudao.module.system.service.tmglglgxwl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglglgxwl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglglgxwl.TmglglgxwlDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmglglgxwl.TmglglgxwlMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 关系网络数据 Service 实现类
 *
 * @author 芋道源码
 */
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
@Service
@Validated
public class TmglglgxwlServiceImpl implements TmglglgxwlService {

    @Resource
    private TmglglgxwlMapper tmglglgxwlMapper;

    @Override
    public String createTmglglgxwl(TmglglgxwlSaveReqVO createReqVO) {
        // 插入
        TmglglgxwlDO tmglglgxwl = BeanUtils.toBean(createReqVO, TmglglgxwlDO.class);
        tmglglgxwlMapper.insert(tmglglgxwl);
        // 返回
        return tmglglgxwl.getId();
    }

    @Override
    public void updateTmglglgxwl(TmglglgxwlSaveReqVO updateReqVO) {
        // 校验存在
        validateTmglglgxwlExists(updateReqVO.getId());
        // 更新
        TmglglgxwlDO updateObj = BeanUtils.toBean(updateReqVO, TmglglgxwlDO.class);
        tmglglgxwlMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmglglgxwl(String id) {
        // 校验存在
        validateTmglglgxwlExists(id);
        // 删除
        tmglglgxwlMapper.deleteById(id);
    }

    private void validateTmglglgxwlExists(String id) {
        if (tmglglgxwlMapper.selectById(id) == null) {
            throw exception(TMGLGLGXWL_NOT_EXISTS);
        }
    }

    @Override
    public TmglglgxwlDO getTmglglgxwl(String id) {
        return tmglglgxwlMapper.selectById(id);
    }

    @Override
    public PageResult<TmglglgxwlDO> getTmglglgxwlPage(TmglglgxwlPageReqVO pageReqVO) {
        return tmglglgxwlMapper.selectPage(pageReqVO);
    }

}