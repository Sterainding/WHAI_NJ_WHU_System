package cn.iocoder.yudao.module.system.service.tmglzkyjbg;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglzkyjbg.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjbg.TmglzkyjbgDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 智库研究报告数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmglzkyjbgService {

    /**
     * 创建智库研究报告数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmglzkyjbg(@Valid TmglzkyjbgSaveReqVO createReqVO);

    /**
     * 更新智库研究报告数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmglzkyjbg(@Valid TmglzkyjbgSaveReqVO updateReqVO);

    /**
     * 删除智库研究报告数据
     *
     * @param id 编号
     */
    void deleteTmglzkyjbg(String id);

    /**
     * 获得智库研究报告数据
     *
     * @param id 编号
     * @return 智库研究报告数据
     */
    TmglzkyjbgDO getTmglzkyjbg(String id);

    /**
     * 获得智库研究报告数据分页
     *
     * @param pageReqVO 分页查询
     * @return 智库研究报告数据分页
     */
    PageResult<TmglzkyjbgDO> getTmglzkyjbgPage(TmglzkyjbgPageReqVO pageReqVO);

}