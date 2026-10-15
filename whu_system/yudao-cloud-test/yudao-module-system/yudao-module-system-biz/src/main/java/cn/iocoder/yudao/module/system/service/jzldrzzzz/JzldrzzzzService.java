package cn.iocoder.yudao.module.system.service.jzldrzzzz;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrzzzz.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrzzzz.JzldrzzzzDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 政治主张数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrzzzzService {

    /**
     * 创建政治主张数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrzzzz(@Valid JzldrzzzzSaveReqVO createReqVO);

    /**
     * 更新政治主张数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrzzzz(@Valid JzldrzzzzSaveReqVO updateReqVO);

    /**
     * 删除政治主张数据
     *
     * @param id 编号
     */
    void deleteJzldrzzzz(String id);

    /**
     * 获得政治主张数据
     *
     * @param id 编号
     * @return 政治主张数据
     */
    JzldrzzzzDO getJzldrzzzz(String id);

    /**
     * 获得政治主张数据分页
     *
     * @param pageReqVO 分页查询
     * @return 政治主张数据分页
     */
    PageResult<JzldrzzzzDO> getJzldrzzzzPage(JzldrzzzzPageReqVO pageReqVO);

}