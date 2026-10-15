package cn.iocoder.yudao.module.system.service.tmgltmdxjs;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmdxjs.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxjs.TmgltmdxjsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 军售数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmgltmdxjsService {

    /**
     * 创建军售数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmgltmdxjs(@Valid TmgltmdxjsSaveReqVO createReqVO);

    /**
     * 更新军售数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmgltmdxjs(@Valid TmgltmdxjsSaveReqVO updateReqVO);

    /**
     * 删除军售数据
     *
     * @param id 编号
     */
    void deleteTmgltmdxjs(String id);

    /**
     * 获得军售数据
     *
     * @param id 编号
     * @return 军售数据
     */
    TmgltmdxjsDO getTmgltmdxjs(String id);

    /**
     * 获得军售数据分页
     *
     * @param pageReqVO 分页查询
     * @return 军售数据分页
     */
    PageResult<TmgltmdxjsDO> getTmgltmdxjsPage(TmgltmdxjsPageReqVO pageReqVO);

}