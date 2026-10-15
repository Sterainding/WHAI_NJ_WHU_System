package cn.iocoder.yudao.module.system.service.hwtxzcmbsb;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.hwtxzcmbsb.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcmbsb.HwtxzcmbsbDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.hwtxzcmbsb.HwtxzcmbsbMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")

/**
 * 红外目标识别数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated


public class HwtxzcmbsbServiceImpl implements HwtxzcmbsbService {

    @Resource
    private HwtxzcmbsbMapper hwtxzcmbsbMapper;

    @Override
    public String createHwtxzcmbsb(HwtxzcmbsbSaveReqVO createReqVO) {
        // 插入
        HwtxzcmbsbDO hwtxzcmbsb = BeanUtils.toBean(createReqVO, HwtxzcmbsbDO.class);
        hwtxzcmbsbMapper.insert(hwtxzcmbsb);
        // 返回
        return hwtxzcmbsb.getId();
    }

    @Override
    public void updateHwtxzcmbsb(HwtxzcmbsbSaveReqVO updateReqVO) {
        // 校验存在
        validateHwtxzcmbsbExists(updateReqVO.getId());
        // 更新
        HwtxzcmbsbDO updateObj = BeanUtils.toBean(updateReqVO, HwtxzcmbsbDO.class);
        hwtxzcmbsbMapper.updateById(updateObj);
    }

    @Override
    public void deleteHwtxzcmbsb(String id) {
        // 校验存在
        validateHwtxzcmbsbExists(id);
        // 删除
        hwtxzcmbsbMapper.deleteById(id);
    }

    private void validateHwtxzcmbsbExists(String id) {
        if (hwtxzcmbsbMapper.selectById(id) == null) {
            throw exception(HWTXZCMBSB_NOT_EXISTS);
        }
    }

    @Override
    public HwtxzcmbsbDO getHwtxzcmbsb(String id) {
        return hwtxzcmbsbMapper.selectById(id);
    }

    @Override
    public PageResult<HwtxzcmbsbDO> getHwtxzcmbsbPage(HwtxzcmbsbPageReqVO pageReqVO) {
        return hwtxzcmbsbMapper.selectPage(pageReqVO);
    }

}