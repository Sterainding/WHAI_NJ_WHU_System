package cn.iocoder.yudao.module.system.service.tmgltmfwys;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmfwys.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmfwys.TmgltmfwysDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 台美防务预算数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmgltmfwysService {

    /**
     * 创建台美防务预算数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmgltmfwys(@Valid TmgltmfwysSaveReqVO createReqVO);

    /**
     * 更新台美防务预算数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmgltmfwys(@Valid TmgltmfwysSaveReqVO updateReqVO);

    /**
     * 删除台美防务预算数据
     *
     * @param id 编号
     */
    void deleteTmgltmfwys(String id);

    /**
     * 获得台美防务预算数据
     *
     * @param id 编号
     * @return 台美防务预算数据
     */
    TmgltmfwysDO getTmgltmfwys(String id);

    /**
     * 获得台美防务预算数据分页
     *
     * @param pageReqVO 分页查询
     * @return 台美防务预算数据分页
     */
    PageResult<TmgltmfwysDO> getTmgltmfwysPage(TmgltmfwysPageReqVO pageReqVO);

}