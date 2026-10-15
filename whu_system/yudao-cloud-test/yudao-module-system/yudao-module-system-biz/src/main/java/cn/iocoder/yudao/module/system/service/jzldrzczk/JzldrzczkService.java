package cn.iocoder.yudao.module.system.service.jzldrzczk;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrzczk.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrzczk.JzldrzczkDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 资产状况数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrzczkService {

    /**
     * 创建资产状况数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrzczk(@Valid JzldrzczkSaveReqVO createReqVO);

    /**
     * 更新资产状况数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrzczk(@Valid JzldrzczkSaveReqVO updateReqVO);

    /**
     * 删除资产状况数据
     *
     * @param id 编号
     */
    void deleteJzldrzczk(String id);

    /**
     * 获得资产状况数据
     *
     * @param id 编号
     * @return 资产状况数据
     */
    JzldrzczkDO getJzldrzczk(String id);

    /**
     * 获得资产状况数据分页
     *
     * @param pageReqVO 分页查询
     * @return 资产状况数据分页
     */
    PageResult<JzldrzczkDO> getJzldrzczkPage(JzldrzczkPageReqVO pageReqVO);

}