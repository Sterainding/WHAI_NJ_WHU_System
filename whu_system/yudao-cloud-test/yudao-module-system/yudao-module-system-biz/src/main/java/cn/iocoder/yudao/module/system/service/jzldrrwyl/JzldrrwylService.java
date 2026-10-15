package cn.iocoder.yudao.module.system.service.jzldrrwyl;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwyl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwyl.JzldrrwylDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 人物言论 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrrwylService {

    /**
     * 创建人物言论
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrrwyl(@Valid JzldrrwylSaveReqVO createReqVO);

    /**
     * 更新人物言论
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrrwyl(@Valid JzldrrwylSaveReqVO updateReqVO);

    /**
     * 删除人物言论
     *
     * @param id 编号
     */
    void deleteJzldrrwyl(String id);

    /**
     * 获得人物言论
     *
     * @param id 编号
     * @return 人物言论
     */
    JzldrrwylDO getJzldrrwyl(String id);

    /**
     * 获得人物言论分页
     *
     * @param pageReqVO 分页查询
     * @return 人物言论分页
     */
    PageResult<JzldrrwylDO> getJzldrrwylPage(JzldrrwylPageReqVO pageReqVO);

}