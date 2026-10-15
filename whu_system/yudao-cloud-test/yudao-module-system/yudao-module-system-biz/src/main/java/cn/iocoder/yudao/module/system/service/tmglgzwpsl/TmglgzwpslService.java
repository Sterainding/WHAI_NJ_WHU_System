package cn.iocoder.yudao.module.system.service.tmglgzwpsl;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglgzwpsl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglgzwpsl.TmglgzwpslDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 购置物品及数量数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmglgzwpslService {

    /**
     * 创建购置物品及数量数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmglgzwpsl(@Valid TmglgzwpslSaveReqVO createReqVO);

    /**
     * 更新购置物品及数量数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmglgzwpsl(@Valid TmglgzwpslSaveReqVO updateReqVO);

    /**
     * 删除购置物品及数量数据
     *
     * @param id 编号
     */
    void deleteTmglgzwpsl(String id);

    /**
     * 获得购置物品及数量数据
     *
     * @param id 编号
     * @return 购置物品及数量数据
     */
    TmglgzwpslDO getTmglgzwpsl(String id);

    /**
     * 获得购置物品及数量数据分页
     *
     * @param pageReqVO 分页查询
     * @return 购置物品及数量数据分页
     */
    PageResult<TmglgzwpslDO> getTmglgzwpslPage(TmglgzwpslPageReqVO pageReqVO);

}