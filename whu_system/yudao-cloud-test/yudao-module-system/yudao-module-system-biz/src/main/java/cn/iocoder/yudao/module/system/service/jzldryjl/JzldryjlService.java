package cn.iocoder.yudao.module.system.service.jzldryjl;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldryjl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldryjl.JzldryjlDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 教育经历数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldryjlService {

    /**
     * 创建教育经历数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldryjl(@Valid JzldryjlSaveReqVO createReqVO);

    /**
     * 更新教育经历数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldryjl(@Valid JzldryjlSaveReqVO updateReqVO);

    /**
     * 删除教育经历数据
     *
     * @param id 编号
     */
    void deleteJzldryjl(String id);

    /**
     * 获得教育经历数据
     *
     * @param id 编号
     * @return 教育经历数据
     */
    JzldryjlDO getJzldryjl(String id);

    /**
     * 获得教育经历数据分页
     *
     * @param pageReqVO 分页查询
     * @return 教育经历数据分页
     */
    PageResult<JzldryjlDO> getJzldryjlPage(JzldryjlPageReqVO pageReqVO);

}