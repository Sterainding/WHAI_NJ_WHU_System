package cn.iocoder.yudao.module.system.service.hwtxzcmbsb;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.hwtxzcmbsb.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcmbsb.HwtxzcmbsbDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 红外目标识别数据 Service 接口
 *
 * @author 芋道源码
 */
public interface HwtxzcmbsbService {

    /**
     * 创建红外目标识别数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createHwtxzcmbsb(@Valid HwtxzcmbsbSaveReqVO createReqVO);

    /**
     * 更新红外目标识别数据
     *
     * @param updateReqVO 更新信息
     */
    void updateHwtxzcmbsb(@Valid HwtxzcmbsbSaveReqVO updateReqVO);

    /**
     * 删除红外目标识别数据
     *
     * @param id 编号
     */
    void deleteHwtxzcmbsb(String id);

    /**
     * 获得红外目标识别数据
     *
     * @param id 编号
     * @return 红外目标识别数据
     */
    HwtxzcmbsbDO getHwtxzcmbsb(String id);

    /**
     * 获得红外目标识别数据分页
     *
     * @param pageReqVO 分页查询
     * @return 红外目标识别数据分页
     */
    PageResult<HwtxzcmbsbDO> getHwtxzcmbsbPage(HwtxzcmbsbPageReqVO pageReqVO);

}