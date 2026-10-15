package cn.iocoder.yudao.module.system.service.tmglzkyjbg;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglzkyjbg.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjbg.TmglzkyjbgDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmglzkyjbg.TmglzkyjbgMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 智库研究报告数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TmglzkyjbgServiceImpl implements TmglzkyjbgService {

    @Resource
    private TmglzkyjbgMapper tmglzkyjbgMapper;

    @Override
    public String createTmglzkyjbg(TmglzkyjbgSaveReqVO createReqVO) {
        // 插入
        TmglzkyjbgDO tmglzkyjbg = BeanUtils.toBean(createReqVO, TmglzkyjbgDO.class);
        tmglzkyjbgMapper.insert(tmglzkyjbg);
        // 返回
        return tmglzkyjbg.getId();
    }

    @Override
    public void updateTmglzkyjbg(TmglzkyjbgSaveReqVO updateReqVO) {
        // 校验存在
        validateTmglzkyjbgExists(updateReqVO.getId());
        // 更新
        TmglzkyjbgDO updateObj = BeanUtils.toBean(updateReqVO, TmglzkyjbgDO.class);
        tmglzkyjbgMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmglzkyjbg(String id) {
        // 校验存在
        validateTmglzkyjbgExists(id);
        // 删除
        tmglzkyjbgMapper.deleteById(id);
    }

    private void validateTmglzkyjbgExists(String id) {
        if (tmglzkyjbgMapper.selectById(id) == null) {
            throw exception(TMGLZKYJBG_NOT_EXISTS);
        }
    }

    @Override
    public TmglzkyjbgDO getTmglzkyjbg(String id) {
        return tmglzkyjbgMapper.selectById(id);
    }

    @Override
    public PageResult<TmglzkyjbgDO> getTmglzkyjbgPage(TmglzkyjbgPageReqVO pageReqVO) {
        return tmglzkyjbgMapper.selectPage(pageReqVO);
    }

}