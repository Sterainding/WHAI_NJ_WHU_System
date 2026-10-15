package cn.iocoder.yudao.module.system.service.jzldrrwbd;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwbd.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwbd.JzldrrwbdDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 人物报道数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrrwbdService {

    /**
     * 创建人物报道数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrrwbd(@Valid JzldrrwbdSaveReqVO createReqVO);

    /**
     * 更新人物报道数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrrwbd(@Valid JzldrrwbdSaveReqVO updateReqVO);

    /**
     * 删除人物报道数据
     *
     * @param id 编号
     */
    void deleteJzldrrwbd(String id);

    /**
     * 获得人物报道数据
     *
     * @param id 编号
     * @return 人物报道数据
     */
    JzldrrwbdDO getJzldrrwbd(String id);

    /**
     * 获得人物报道数据分页
     *
     * @param pageReqVO 分页查询
     * @return 人物报道数据分页
     */
    PageResult<JzldrrwbdDO> getJzldrrwbdPage(JzldrrwbdPageReqVO pageReqVO);

}