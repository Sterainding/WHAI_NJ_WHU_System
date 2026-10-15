package cn.iocoder.yudao.module.system.service.jzldrjtqk;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrjtqk.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrjtqk.JzldrjtqkDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 家庭情况数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrjtqkService {

    /**
     * 创建家庭情况数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrjtqk(@Valid JzldrjtqkSaveReqVO createReqVO);

    /**
     * 更新家庭情况数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrjtqk(@Valid JzldrjtqkSaveReqVO updateReqVO);

    /**
     * 删除家庭情况数据
     *
     * @param id 编号
     */
    void deleteJzldrjtqk(String id);

    /**
     * 获得家庭情况数据
     *
     * @param id 编号
     * @return 家庭情况数据
     */
    JzldrjtqkDO getJzldrjtqk(String id);

    /**
     * 获得家庭情况数据分页
     *
     * @param pageReqVO 分页查询
     * @return 家庭情况数据分页
     */
    PageResult<JzldrjtqkDO> getJzldrjtqkPage(JzldrjtqkPageReqVO pageReqVO);

}