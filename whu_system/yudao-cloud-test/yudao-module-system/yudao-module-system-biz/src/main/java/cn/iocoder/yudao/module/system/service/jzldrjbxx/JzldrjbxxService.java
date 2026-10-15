package cn.iocoder.yudao.module.system.service.jzldrjbxx;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrjbxx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrjbxx.JzldrjbxxDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 基本信息数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrjbxxService {

    /**
     * 创建基本信息数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrjbxx(@Valid JzldrjbxxSaveReqVO createReqVO);

    /**
     * 更新基本信息数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrjbxx(@Valid JzldrjbxxSaveReqVO updateReqVO);

    /**
     * 删除基本信息数据
     *
     * @param id 编号
     */
    void deleteJzldrjbxx(String id);

    /**
     * 获得基本信息数据
     *
     * @param id 编号
     * @return 基本信息数据
     */
    JzldrjbxxDO getJzldrjbxx(String id);

    /**
     * 获得基本信息数据分页
     *
     * @param pageReqVO 分页查询
     * @return 基本信息数据分页
     */
    PageResult<JzldrjbxxDO> getJzldrjbxxPage(JzldrjbxxPageReqVO pageReqVO);

}