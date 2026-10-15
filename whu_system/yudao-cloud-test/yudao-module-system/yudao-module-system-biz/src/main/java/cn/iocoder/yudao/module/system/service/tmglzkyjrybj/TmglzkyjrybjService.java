package cn.iocoder.yudao.module.system.service.tmglzkyjrybj;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglzkyjrybj.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjrybj.TmglzkyjrybjDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 智库研究员背景数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmglzkyjrybjService {

    /**
     * 创建智库研究员背景数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmglzkyjrybj(@Valid TmglzkyjrybjSaveReqVO createReqVO);

    /**
     * 更新智库研究员背景数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmglzkyjrybj(@Valid TmglzkyjrybjSaveReqVO updateReqVO);

    /**
     * 删除智库研究员背景数据
     *
     * @param id 编号
     */
    void deleteTmglzkyjrybj(String id);

    /**
     * 获得智库研究员背景数据
     *
     * @param id 编号
     * @return 智库研究员背景数据
     */
    TmglzkyjrybjDO getTmglzkyjrybj(String id);

    /**
     * 获得智库研究员背景数据分页
     *
     * @param pageReqVO 分页查询
     * @return 智库研究员背景数据分页
     */
    PageResult<TmglzkyjrybjDO> getTmglzkyjrybjPage(TmglzkyjrybjPageReqVO pageReqVO);

}