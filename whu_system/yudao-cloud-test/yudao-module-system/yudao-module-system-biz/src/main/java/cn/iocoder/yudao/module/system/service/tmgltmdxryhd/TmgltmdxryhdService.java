package cn.iocoder.yudao.module.system.service.tmgltmdxryhd;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmdxryhd.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxryhd.TmgltmdxryhdDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 人员活动数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmgltmdxryhdService {

    /**
     * 创建人员活动数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmgltmdxryhd(@Valid TmgltmdxryhdSaveReqVO createReqVO);

    /**
     * 更新人员活动数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmgltmdxryhd(@Valid TmgltmdxryhdSaveReqVO updateReqVO);

    /**
     * 删除人员活动数据
     *
     * @param id 编号
     */
    void deleteTmgltmdxryhd(String id);

    /**
     * 获得人员活动数据
     *
     * @param id 编号
     * @return 人员活动数据
     */
    TmgltmdxryhdDO getTmgltmdxryhd(String id);

    /**
     * 获得人员活动数据分页
     *
     * @param pageReqVO 分页查询
     * @return 人员活动数据分页
     */
    PageResult<TmgltmdxryhdDO> getTmgltmdxryhdPage(TmgltmdxryhdPageReqVO pageReqVO);

}