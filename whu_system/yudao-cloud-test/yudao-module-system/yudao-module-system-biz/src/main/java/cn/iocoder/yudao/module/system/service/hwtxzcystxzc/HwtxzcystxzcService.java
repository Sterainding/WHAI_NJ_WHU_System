package cn.iocoder.yudao.module.system.service.hwtxzcystxzc;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.hwtxzcystxzc.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcystxzc.HwtxzcystxzcDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 红外原始图像侦察数据 Service 接口
 *
 * @author 芋道源码
 */
public interface HwtxzcystxzcService {

    /**
     * 创建红外原始图像侦察数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createHwtxzcystxzc(@Valid HwtxzcystxzcSaveReqVO createReqVO);

    /**
     * 更新红外原始图像侦察数据
     *
     * @param updateReqVO 更新信息
     */
    void updateHwtxzcystxzc(@Valid HwtxzcystxzcSaveReqVO updateReqVO);

    /**
     * 删除红外原始图像侦察数据
     *
     * @param id 编号
     */
    void deleteHwtxzcystxzc(String id);

    /**
     * 获得红外原始图像侦察数据
     *
     * @param id 编号
     * @return 红外原始图像侦察数据
     */
    HwtxzcystxzcDO getHwtxzcystxzc(String id);

    /**
     * 获得红外原始图像侦察数据分页
     *
     * @param pageReqVO 分页查询
     * @return 红外原始图像侦察数据分页
     */
    PageResult<HwtxzcystxzcDO> getHwtxzcystxzcPage(HwtxzcystxzcPageReqVO pageReqVO);

}