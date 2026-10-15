package cn.iocoder.yudao.module.system.service.tmglgzwpsl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglgzwpsl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglgzwpsl.TmglgzwpslDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmglgzwpsl.TmglgzwpslMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 购置物品及数量数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TmglgzwpslServiceImpl implements TmglgzwpslService {

    @Resource
    private TmglgzwpslMapper tmglgzwpslMapper;

    @Override
    public String createTmglgzwpsl(TmglgzwpslSaveReqVO createReqVO) {
        // 插入
        TmglgzwpslDO tmglgzwpsl = BeanUtils.toBean(createReqVO, TmglgzwpslDO.class);
        tmglgzwpslMapper.insert(tmglgzwpsl);
        // 返回
        return tmglgzwpsl.getItemId();
    }

    @Override
    public void updateTmglgzwpsl(TmglgzwpslSaveReqVO updateReqVO) {
        // 校验存在
        validateTmglgzwpslExists(updateReqVO.getItemId());
        // 更新
        TmglgzwpslDO updateObj = BeanUtils.toBean(updateReqVO, TmglgzwpslDO.class);
        tmglgzwpslMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmglgzwpsl(String id) {
        // 校验存在
        validateTmglgzwpslExists(id);
        // 删除
        tmglgzwpslMapper.deleteById(id);
    }

    private void validateTmglgzwpslExists(String id) {
        if (tmglgzwpslMapper.selectById(id) == null) {
            throw exception(TMGLGZWPSL_NOT_EXISTS);
        }
    }

    @Override
    public TmglgzwpslDO getTmglgzwpsl(String id) {
        return tmglgzwpslMapper.selectById(id);
    }

    @Override
    public PageResult<TmglgzwpslDO> getTmglgzwpslPage(TmglgzwpslPageReqVO pageReqVO) {
        return tmglgzwpslMapper.selectPage(pageReqVO);
    }

}