package cn.iocoder.yudao.module.system.service.tmglglrwzl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglglrwzl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglglrwzl.TmglglrwzlDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmglglrwzl.TmglglrwzlMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 人员资料数据 Service 实现类
 *
 * @author 芋道源码
 */
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
@Service
@Validated
public class TmglglrwzlServiceImpl implements TmglglrwzlService {

    @Resource
    private TmglglrwzlMapper tmglglrwzlMapper;

    @Override
    public String createTmglglrwzl(TmglglrwzlSaveReqVO createReqVO) {
        // 插入
        TmglglrwzlDO tmglglrwzl = BeanUtils.toBean(createReqVO, TmglglrwzlDO.class);
        tmglglrwzlMapper.insert(tmglglrwzl);
        // 返回
        return tmglglrwzl.getId();
    }

    @Override
    public void updateTmglglrwzl(TmglglrwzlSaveReqVO updateReqVO) {
        // 校验存在
        validateTmglglrwzlExists(updateReqVO.getId());
        // 更新
        TmglglrwzlDO updateObj = BeanUtils.toBean(updateReqVO, TmglglrwzlDO.class);
        tmglglrwzlMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmglglrwzl(String id) {
        // 校验存在
        validateTmglglrwzlExists(id);
        // 删除
        tmglglrwzlMapper.deleteById(id);
    }

    private void validateTmglglrwzlExists(String id) {
        if (tmglglrwzlMapper.selectById(id) == null) {
            throw exception(TMGLGLRWZL_NOT_EXISTS);
        }
    }

    @Override
    public TmglglrwzlDO getTmglglrwzl(String id) {
        return tmglglrwzlMapper.selectById(id);
    }

    @Override
    public PageResult<TmglglrwzlDO> getTmglglrwzlPage(TmglglrwzlPageReqVO pageReqVO) {
        return tmglglrwzlMapper.selectPage(pageReqVO);
    }

}