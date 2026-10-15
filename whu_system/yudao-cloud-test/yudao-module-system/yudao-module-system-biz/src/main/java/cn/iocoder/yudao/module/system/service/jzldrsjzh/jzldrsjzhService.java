package cn.iocoder.yudao.module.system.service.jzldrsjzh;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrsjzh.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrsjzh.jzldrsjzhDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 社交账号数据 Service 接口
 *
 * @author 芋道源码
 */
public interface jzldrsjzhService {

    /**
     * 创建社交账号数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createjzldrsjzh(@Valid jzldrsjzhSaveReqVO createReqVO);

    /**
     * 更新社交账号数据
     *
     * @param updateReqVO 更新信息
     */
    void updatejzldrsjzh(@Valid jzldrsjzhSaveReqVO updateReqVO);

    /**
     * 删除社交账号数据
     *
     * @param id 编号
     */
    void deletejzldrsjzh(String id);

    /**
     * 获得社交账号数据
     *
     * @param id 编号
     * @return 社交账号数据
     */
    jzldrsjzhDO getjzldrsjzh(String id);

    /**
     * 获得社交账号数据分页
     *
     * @param pageReqVO 分页查询
     * @return 社交账号数据分页
     */
    PageResult<jzldrsjzhDO> getjzldrsjzhPage(jzldrsjzhPageReqVO pageReqVO);

}