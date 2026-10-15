package cn.iocoder.yudao.module.system.service.tmgltmdxryhd;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmdxryhd.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxryhd.TmgltmdxryhdDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmgltmdxryhd.TmgltmdxryhdMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 人员活动数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TmgltmdxryhdServiceImpl implements TmgltmdxryhdService {

    @Resource
    private TmgltmdxryhdMapper tmgltmdxryhdMapper;

    @Override
    public String createTmgltmdxryhd(TmgltmdxryhdSaveReqVO createReqVO) {
        // 插入
        TmgltmdxryhdDO tmgltmdxryhd = BeanUtils.toBean(createReqVO, TmgltmdxryhdDO.class);
        tmgltmdxryhdMapper.insert(tmgltmdxryhd);
        // 返回
        return tmgltmdxryhd.getId();
    }

    @Override
    public void updateTmgltmdxryhd(TmgltmdxryhdSaveReqVO updateReqVO) {
        // 校验存在
        validateTmgltmdxryhdExists(updateReqVO.getId());
        // 更新
        TmgltmdxryhdDO updateObj = BeanUtils.toBean(updateReqVO, TmgltmdxryhdDO.class);
        tmgltmdxryhdMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmgltmdxryhd(String id) {
        // 校验存在
        validateTmgltmdxryhdExists(id);
        // 删除
        tmgltmdxryhdMapper.deleteById(id);
    }

    private void validateTmgltmdxryhdExists(String id) {
        if (tmgltmdxryhdMapper.selectById(id) == null) {
            throw exception(TMGLTMDXRYHD_NOT_EXISTS);
        }
    }

    @Override
    public TmgltmdxryhdDO getTmgltmdxryhd(String id) {
        return tmgltmdxryhdMapper.selectById(id);
    }

    @Override
    public PageResult<TmgltmdxryhdDO> getTmgltmdxryhdPage(TmgltmdxryhdPageReqVO pageReqVO) {
        return tmgltmdxryhdMapper.selectPage(pageReqVO);
    }

}