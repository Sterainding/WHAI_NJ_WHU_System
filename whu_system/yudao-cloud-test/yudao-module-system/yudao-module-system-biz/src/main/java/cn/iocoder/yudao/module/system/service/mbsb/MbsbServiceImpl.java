package cn.iocoder.yudao.module.system.service.mbsb;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.mbsb.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.mbsb.MbsbDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.mbsb.MbsbMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
/**
 * 红外目标识别数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MbsbServiceImpl implements MbsbService {

    @Resource
    private MbsbMapper mbsbMapper;

    @Override
    public String createMbsb(MbsbSaveReqVO createReqVO) {
        // 插入
        MbsbDO mbsb = BeanUtils.toBean(createReqVO, MbsbDO.class);
        mbsbMapper.insert(mbsb);
        // 返回
        return mbsb.getId();
    }

    @Override
    public void updateMbsb(MbsbSaveReqVO updateReqVO) {
        // 校验存在
        validateMbsbExists(updateReqVO.getId());
        // 更新
        MbsbDO updateObj = BeanUtils.toBean(updateReqVO, MbsbDO.class);
        mbsbMapper.updateById(updateObj);
    }

    @Override
    public void deleteMbsb(String id) {
        // 校验存在
        validateMbsbExists(id);
        // 删除
        mbsbMapper.deleteById(id);
    }

    private void validateMbsbExists(String id) {
        if (mbsbMapper.selectById(id) == null) {
            throw exception(MBSB_NOT_EXISTS);
        }
    }

    @Override
    public MbsbDO getMbsb(String id) {
        return mbsbMapper.selectById(id);
    }

    @Override
    public PageResult<MbsbDO> getMbsbPage(MbsbPageReqVO pageReqVO) {
        return mbsbMapper.selectPage(pageReqVO);
    }

}