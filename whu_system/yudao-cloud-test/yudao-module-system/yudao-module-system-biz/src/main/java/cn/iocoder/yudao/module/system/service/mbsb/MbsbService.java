package cn.iocoder.yudao.module.system.service.mbsb;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.mbsb.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.mbsb.MbsbDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 红外目标识别数据 Service 接口
 *
 * @author 芋道源码
 */
public interface MbsbService {

    /**
     * 创建红外目标识别数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createMbsb(@Valid MbsbSaveReqVO createReqVO);

    /**
     * 更新红外目标识别数据
     *
     * @param updateReqVO 更新信息
     */
    void updateMbsb(@Valid MbsbSaveReqVO updateReqVO);

    /**
     * 删除红外目标识别数据
     *
     * @param id 编号
     */
    void deleteMbsb(String id);

    /**
     * 获得红外目标识别数据
     *
     * @param id 编号
     * @return 红外目标识别数据
     */
    MbsbDO getMbsb(String id);

    /**
     * 获得红外目标识别数据分页
     *
     * @param pageReqVO 分页查询
     * @return 红外目标识别数据分页
     */
    PageResult<MbsbDO> getMbsbPage(MbsbPageReqVO pageReqVO);

}