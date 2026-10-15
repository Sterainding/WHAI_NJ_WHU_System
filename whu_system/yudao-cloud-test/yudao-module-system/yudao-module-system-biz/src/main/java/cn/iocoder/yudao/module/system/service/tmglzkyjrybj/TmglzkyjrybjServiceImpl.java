package cn.iocoder.yudao.module.system.service.tmglzkyjrybj;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglzkyjrybj.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjrybj.TmglzkyjrybjDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmglzkyjrybj.TmglzkyjrybjMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 智库研究员背景数据 Service 实现类
 *
 * @author 芋道源码
 */
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
@Service
@Validated
public class TmglzkyjrybjServiceImpl implements TmglzkyjrybjService {

    @Resource
    private TmglzkyjrybjMapper tmglzkyjrybjMapper;

    @Override
    public String createTmglzkyjrybj(TmglzkyjrybjSaveReqVO createReqVO) {
        // 插入
        TmglzkyjrybjDO tmglzkyjrybj = BeanUtils.toBean(createReqVO, TmglzkyjrybjDO.class);
        tmglzkyjrybjMapper.insert(tmglzkyjrybj);
        // 返回
        return tmglzkyjrybj.getId();
    }

    @Override
    public void updateTmglzkyjrybj(TmglzkyjrybjSaveReqVO updateReqVO) {
        // 校验存在
        validateTmglzkyjrybjExists(updateReqVO.getId());
        // 更新
        TmglzkyjrybjDO updateObj = BeanUtils.toBean(updateReqVO, TmglzkyjrybjDO.class);
        tmglzkyjrybjMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmglzkyjrybj(String id) {
        // 校验存在
        validateTmglzkyjrybjExists(id);
        // 删除
        tmglzkyjrybjMapper.deleteById(id);
    }

    private void validateTmglzkyjrybjExists(String id) {
        if (tmglzkyjrybjMapper.selectById(id) == null) {
            throw exception(TMGLZKYJRYBJ_NOT_EXISTS);
        }
    }

    @Override
    public TmglzkyjrybjDO getTmglzkyjrybj(String id) {
        return tmglzkyjrybjMapper.selectById(id);
    }

    @Override
    public PageResult<TmglzkyjrybjDO> getTmglzkyjrybjPage(TmglzkyjrybjPageReqVO pageReqVO) {
        return tmglzkyjrybjMapper.selectPage(pageReqVO);
    }

}