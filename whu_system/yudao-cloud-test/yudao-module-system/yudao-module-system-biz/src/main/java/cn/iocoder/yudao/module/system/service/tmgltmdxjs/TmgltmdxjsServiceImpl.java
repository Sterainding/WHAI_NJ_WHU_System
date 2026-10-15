package cn.iocoder.yudao.module.system.service.tmgltmdxjs;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmdxjs.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxjs.TmgltmdxjsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmgltmdxjs.TmgltmdxjsMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 军售数据 Service 实现类
 *
 * @author 芋道源码
 */
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
@Service
@Validated
public class TmgltmdxjsServiceImpl implements TmgltmdxjsService {

    @Resource
    private TmgltmdxjsMapper tmgltmdxjsMapper;

    @Override
    public String createTmgltmdxjs(TmgltmdxjsSaveReqVO createReqVO) {
        // 插入
        TmgltmdxjsDO tmgltmdxjs = BeanUtils.toBean(createReqVO, TmgltmdxjsDO.class);
        tmgltmdxjsMapper.insert(tmgltmdxjs);
        // 返回
        return tmgltmdxjs.getId();
    }

    @Override
    public void updateTmgltmdxjs(TmgltmdxjsSaveReqVO updateReqVO) {
        // 校验存在
        validateTmgltmdxjsExists(updateReqVO.getId());
        // 更新
        TmgltmdxjsDO updateObj = BeanUtils.toBean(updateReqVO, TmgltmdxjsDO.class);
        tmgltmdxjsMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmgltmdxjs(String id) {
        // 校验存在
        validateTmgltmdxjsExists(id);
        // 删除
        tmgltmdxjsMapper.deleteById(id);
    }

    private void validateTmgltmdxjsExists(String id) {
        if (tmgltmdxjsMapper.selectById(id) == null) {
            throw exception(TMGLTMDXJS_NOT_EXISTS);
        }
    }

    @Override
    public TmgltmdxjsDO getTmgltmdxjs(String id) {
        return tmgltmdxjsMapper.selectById(id);
    }

    @Override
    public PageResult<TmgltmdxjsDO> getTmgltmdxjsPage(TmgltmdxjsPageReqVO pageReqVO) {
        return tmgltmdxjsMapper.selectPage(pageReqVO);
    }

}