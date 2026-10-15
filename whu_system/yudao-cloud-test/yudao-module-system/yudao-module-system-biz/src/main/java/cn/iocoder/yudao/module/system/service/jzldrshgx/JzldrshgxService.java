package cn.iocoder.yudao.module.system.service.jzldrshgx;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrshgx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrshgx.JzldrshgxDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 社会关系数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrshgxService {

    /**
     * 创建社会关系数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrshgx(@Valid JzldrshgxSaveReqVO createReqVO);

    /**
     * 更新社会关系数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrshgx(@Valid JzldrshgxSaveReqVO updateReqVO);

    /**
     * 删除社会关系数据
     *
     * @param id 编号
     */
    void deleteJzldrshgx(String id);

    /**
     * 获得社会关系数据
     *
     * @param id 编号
     * @return 社会关系数据
     */
    JzldrshgxDO getJzldrshgx(String id);

    /**
     * 获得社会关系数据分页
     *
     * @param pageReqVO 分页查询
     * @return 社会关系数据分页
     */
    PageResult<JzldrshgxDO> getJzldrshgxPage(JzldrshgxPageReqVO pageReqVO);

}