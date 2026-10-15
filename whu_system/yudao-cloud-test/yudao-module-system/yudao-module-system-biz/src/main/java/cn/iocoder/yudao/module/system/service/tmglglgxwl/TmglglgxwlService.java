package cn.iocoder.yudao.module.system.service.tmglglgxwl;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglglgxwl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglglgxwl.TmglglgxwlDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 关系网络数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmglglgxwlService {

    /**
     * 创建关系网络数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmglglgxwl(@Valid TmglglgxwlSaveReqVO createReqVO);

    /**
     * 更新关系网络数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmglglgxwl(@Valid TmglglgxwlSaveReqVO updateReqVO);

    /**
     * 删除关系网络数据
     *
     * @param id 编号
     */
    void deleteTmglglgxwl(String id);

    /**
     * 获得关系网络数据
     *
     * @param id 编号
     * @return 关系网络数据
     */
    TmglglgxwlDO getTmglglgxwl(String id);

    /**
     * 获得关系网络数据分页
     *
     * @param pageReqVO 分页查询
     * @return 关系网络数据分页
     */
    PageResult<TmglglgxwlDO> getTmglglgxwlPage(TmglglgxwlPageReqVO pageReqVO);

}