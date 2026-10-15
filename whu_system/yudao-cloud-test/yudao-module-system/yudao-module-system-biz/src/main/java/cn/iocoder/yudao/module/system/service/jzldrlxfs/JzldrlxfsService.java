package cn.iocoder.yudao.module.system.service.jzldrlxfs;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrlxfs.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrlxfs.JzldrlxfsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 联系方式数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrlxfsService {

    /**
     * 创建联系方式数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrlxfs(@Valid JzldrlxfsSaveReqVO createReqVO);

    /**
     * 更新联系方式数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrlxfs(@Valid JzldrlxfsSaveReqVO updateReqVO);

    /**
     * 删除联系方式数据
     *
     * @param id 编号
     */
    void deleteJzldrlxfs(String id);

    /**
     * 获得联系方式数据
     *
     * @param id 编号
     * @return 联系方式数据
     */
    JzldrlxfsDO getJzldrlxfs(String id);

    /**
     * 获得联系方式数据分页
     *
     * @param pageReqVO 分页查询
     * @return 联系方式数据分页
     */
    PageResult<JzldrlxfsDO> getJzldrlxfsPage(JzldrlxfsPageReqVO pageReqVO);

}