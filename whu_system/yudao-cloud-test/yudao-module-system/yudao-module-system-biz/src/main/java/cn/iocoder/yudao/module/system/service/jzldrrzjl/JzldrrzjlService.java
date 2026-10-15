package cn.iocoder.yudao.module.system.service.jzldrrzjl;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrzjl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrzjl.JzldrrzjlDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 任职经历数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrrzjlService {

    /**
     * 创建任职经历数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrrzjl(@Valid JzldrrzjlSaveReqVO createReqVO);

    /**
     * 更新任职经历数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrrzjl(@Valid JzldrrzjlSaveReqVO updateReqVO);

    /**
     * 删除任职经历数据
     *
     * @param id 编号
     */
    void deleteJzldrrzjl(String id);

    /**
     * 获得任职经历数据
     *
     * @param id 编号
     * @return 任职经历数据
     */
    JzldrrzjlDO getJzldrrzjl(String id);

    /**
     * 获得任职经历数据分页
     *
     * @param pageReqVO 分页查询
     * @return 任职经历数据分页
     */
    PageResult<JzldrrzjlDO> getJzldrrzjlPage(JzldrrzjlPageReqVO pageReqVO);

}