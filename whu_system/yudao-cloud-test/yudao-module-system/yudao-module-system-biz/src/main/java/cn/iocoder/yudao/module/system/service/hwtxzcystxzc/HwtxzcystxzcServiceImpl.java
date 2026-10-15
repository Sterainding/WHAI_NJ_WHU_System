package cn.iocoder.yudao.module.system.service.hwtxzcystxzc;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.hwtxzcystxzc.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcystxzc.HwtxzcystxzcDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.hwtxzcystxzc.HwtxzcystxzcMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 红外原始图像侦察数据 Service 实现类
 *
 * @author 芋道源码
 */
@DS("whu_data")
@Service
@Validated
public class HwtxzcystxzcServiceImpl implements HwtxzcystxzcService {

    @Resource
    private HwtxzcystxzcMapper hwtxzcystxzcMapper;

    @Override
    public String createHwtxzcystxzc(HwtxzcystxzcSaveReqVO createReqVO) {
        // 插入
        HwtxzcystxzcDO hwtxzcystxzc = BeanUtils.toBean(createReqVO, HwtxzcystxzcDO.class);
        hwtxzcystxzcMapper.insert(hwtxzcystxzc);
        // 返回
        return hwtxzcystxzc.getId();
    }

    @Override
    public void updateHwtxzcystxzc(HwtxzcystxzcSaveReqVO updateReqVO) {
        // 校验存在
        validateHwtxzcystxzcExists(updateReqVO.getId());
        // 更新
        HwtxzcystxzcDO updateObj = BeanUtils.toBean(updateReqVO, HwtxzcystxzcDO.class);
        hwtxzcystxzcMapper.updateById(updateObj);
    }

    @Override
    public void deleteHwtxzcystxzc(String id) {
        // 校验存在
        validateHwtxzcystxzcExists(id);
        // 删除
        hwtxzcystxzcMapper.deleteById(id);
    }

    private void validateHwtxzcystxzcExists(String id) {
        if (hwtxzcystxzcMapper.selectById(id) == null) {
            throw exception(HWTXZCYSTXZC_NOT_EXISTS);
        }
    }

    @Override
    public HwtxzcystxzcDO getHwtxzcystxzc(String id) {
        return hwtxzcystxzcMapper.selectById(id);
    }

    @Override
    public PageResult<HwtxzcystxzcDO> getHwtxzcystxzcPage(HwtxzcystxzcPageReqVO pageReqVO) {
        return hwtxzcystxzcMapper.selectPage(pageReqVO);
    }

}