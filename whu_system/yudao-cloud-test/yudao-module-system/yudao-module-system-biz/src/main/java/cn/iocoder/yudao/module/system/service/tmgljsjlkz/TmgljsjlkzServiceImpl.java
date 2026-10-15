package cn.iocoder.yudao.module.system.service.tmgljsjlkz;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.tmgljsjlkz.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgljsjlkz.TmgljsjlkzDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.tmgljsjlkz.TmgljsjlkzMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 军事交流项目和开支数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TmgljsjlkzServiceImpl implements TmgljsjlkzService {

    @Resource
    private TmgljsjlkzMapper tmgljsjlkzMapper;

    @Override
    public String createTmgljsjlkz(TmgljsjlkzSaveReqVO createReqVO) {
        // 插入
        TmgljsjlkzDO tmgljsjlkz = BeanUtils.toBean(createReqVO, TmgljsjlkzDO.class);
        tmgljsjlkzMapper.insert(tmgljsjlkz);
        // 返回
        return tmgljsjlkz.getId();
    }

    @Override
    public void updateTmgljsjlkz(TmgljsjlkzSaveReqVO updateReqVO) {
        // 校验存在
        validateTmgljsjlkzExists(updateReqVO.getId());
        // 更新
        TmgljsjlkzDO updateObj = BeanUtils.toBean(updateReqVO, TmgljsjlkzDO.class);
        tmgljsjlkzMapper.updateById(updateObj);
    }

    @Override
    public void deleteTmgljsjlkz(String id) {
        // 校验存在
        validateTmgljsjlkzExists(id);
        // 删除
        tmgljsjlkzMapper.deleteById(id);
    }

    private void validateTmgljsjlkzExists(String id) {
        if (tmgljsjlkzMapper.selectById(id) == null) {
            throw exception(TMGLJSJLKZ_NOT_EXISTS);
        }
    }

    @Override
    public TmgljsjlkzDO getTmgljsjlkz(String id) {
        return tmgljsjlkzMapper.selectById(id);
    }

    @Override
    public PageResult<TmgljsjlkzDO> getTmgljsjlkzPage(TmgljsjlkzPageReqVO pageReqVO) {
        return tmgljsjlkzMapper.selectPage(pageReqVO);
    }

}