package cn.iocoder.yudao.module.system.service.tmgltmfwys;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmfwys.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmfwys.TmgltmfwysDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmgltmfwys.TmgltmfwysMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 台美防务预算数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TmgltmfwysServiceImpl implements TmgltmfwysService {

    @Resource
    private TmgltmfwysMapper tmgltmfwysMapper;

    @Override
    public String createTmgltmfwys(TmgltmfwysSaveReqVO createReqVO) {
        // 插入
        TmgltmfwysDO tmgltmfwys = BeanUtils.toBean(createReqVO, TmgltmfwysDO.class);
        tmgltmfwysMapper.insert(tmgltmfwys);
        // 返回
        return tmgltmfwys.getBudgetId();
    }

    @Override
    public void updateTmgltmfwys(TmgltmfwysSaveReqVO updateReqVO) {
        // 校验存在
        validateTmgltmfwysExists(updateReqVO.getBudgetId());
        // 更新
        TmgltmfwysDO updateObj = BeanUtils.toBean(updateReqVO, TmgltmfwysDO.class);
        tmgltmfwysMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmgltmfwys(String id) {
        // 校验存在
        validateTmgltmfwysExists(id);
        // 删除
        tmgltmfwysMapper.deleteById(id);
    }

    private void validateTmgltmfwysExists(String id) {
        if (tmgltmfwysMapper.selectById(id) == null) {
            throw exception(TMGLTMFWYS_NOT_EXISTS);
        }
    }

    @Override
    public TmgltmfwysDO getTmgltmfwys(String id) {
        return tmgltmfwysMapper.selectById(id);
    }

    @Override
    public PageResult<TmgltmfwysDO> getTmgltmfwysPage(TmgltmfwysPageReqVO pageReqVO) {
        return tmgltmfwysMapper.selectPage(pageReqVO);
    }

}