package cn.iocoder.yudao.module.system.service.Jzldrzytc;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.Jzldrzytc.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.Jzldrzytc.JzldrzytcDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 专业特长数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrzytcService {

    /**
     * 创建专业特长数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrzytc(@Valid JzldrzytcSaveReqVO createReqVO);

    /**
     * 更新专业特长数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrzytc(@Valid JzldrzytcSaveReqVO updateReqVO);

    /**
     * 删除专业特长数据
     *
     * @param id 编号
     */
    void deleteJzldrzytc(String id);

    /**
     * 获得专业特长数据
     *
     * @param id 编号
     * @return 专业特长数据
     */
    JzldrzytcDO getJzldrzytc(String id);

    /**
     * 获得专业特长数据分页
     *
     * @param pageReqVO 分页查询
     * @return 专业特长数据分页
     */
    PageResult<JzldrzytcDO> getJzldrzytcPage(JzldrzytcPageReqVO pageReqVO);

}