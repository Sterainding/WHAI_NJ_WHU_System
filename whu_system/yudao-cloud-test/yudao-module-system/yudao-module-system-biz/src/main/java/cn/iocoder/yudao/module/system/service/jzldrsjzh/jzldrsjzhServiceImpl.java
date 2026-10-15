package cn.iocoder.yudao.module.system.service.jzldrsjzh;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrsjzh.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrsjzh.jzldrsjzhDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrsjzh.jzldrsjzhMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 社交账号数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class jzldrsjzhServiceImpl implements jzldrsjzhService {

    @Resource
    private jzldrsjzhMapper jzldrsjzhMapper;

    @Override
    public String createjzldrsjzh(jzldrsjzhSaveReqVO createReqVO) {
        // 插入
        jzldrsjzhDO jzldrsjzh = BeanUtils.toBean(createReqVO, jzldrsjzhDO.class);
        jzldrsjzhMapper.insert(jzldrsjzh);
        // 返回
        return jzldrsjzh.getUid();
    }

    @Override
    public void updatejzldrsjzh(jzldrsjzhSaveReqVO updateReqVO) {
        // 校验存在
        validatejzldrsjzhExists(updateReqVO.getUid());
        // 更新
        jzldrsjzhDO updateObj = BeanUtils.toBean(updateReqVO, jzldrsjzhDO.class);
        jzldrsjzhMapper.updateById(updateObj);
    }

    @Override
    public void deletejzldrsjzh(String id) {
        // 校验存在
        validatejzldrsjzhExists(id);
        // 删除
        jzldrsjzhMapper.deleteById(id);
    }

    private void validatejzldrsjzhExists(String id) {
        if (jzldrsjzhMapper.selectById(id) == null) {
            throw exception(JZLDRSJZH_NOT_EXISTS);
        }
    }

    @Override
    public jzldrsjzhDO getjzldrsjzh(String id) {
        return jzldrsjzhMapper.selectById(id);
    }

    @Override
    public PageResult<jzldrsjzhDO> getjzldrsjzhPage(jzldrsjzhPageReqVO pageReqVO) {
        return jzldrsjzhMapper.selectPage(pageReqVO);
    }

}