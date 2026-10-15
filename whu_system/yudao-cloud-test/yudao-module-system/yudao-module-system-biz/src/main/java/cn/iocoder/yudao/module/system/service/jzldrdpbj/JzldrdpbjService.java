package cn.iocoder.yudao.module.system.service.jzldrdpbj;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrdpbj.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrdpbj.JzldrdpbjDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 党派背景数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrdpbjService {

    /**
     * 创建党派背景数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrdpbj(@Valid JzldrdpbjSaveReqVO createReqVO);

    /**
     * 更新党派背景数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrdpbj(@Valid JzldrdpbjSaveReqVO updateReqVO);

    /**
     * 删除党派背景数据
     *
     * @param id 编号
     */
    void deleteJzldrdpbj(String id);

    /**
     * 获得党派背景数据
     *
     * @param id 编号
     * @return 党派背景数据
     */
    JzldrdpbjDO getJzldrdpbj(String id);

    /**
     * 获得党派背景数据分页
     *
     * @param pageReqVO 分页查询
     * @return 党派背景数据分页
     */
    PageResult<JzldrdpbjDO> getJzldrdpbjPage(JzldrdpbjPageReqVO pageReqVO);

}