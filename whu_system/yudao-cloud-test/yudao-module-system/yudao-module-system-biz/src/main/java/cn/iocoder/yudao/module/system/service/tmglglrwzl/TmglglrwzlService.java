package cn.iocoder.yudao.module.system.service.tmglglrwzl;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmglglrwzl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglglrwzl.TmglglrwzlDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 人员资料数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmglglrwzlService {

    /**
     * 创建人员资料数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmglglrwzl(@Valid TmglglrwzlSaveReqVO createReqVO);

    /**
     * 更新人员资料数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmglglrwzl(@Valid TmglglrwzlSaveReqVO updateReqVO);

    /**
     * 删除人员资料数据
     *
     * @param id 编号
     */
    void deleteTmglglrwzl(String id);

    /**
     * 获得人员资料数据
     *
     * @param id 编号
     * @return 人员资料数据
     */
    TmglglrwzlDO getTmglglrwzl(String id);

    /**
     * 获得人员资料数据分页
     *
     * @param pageReqVO 分页查询
     * @return 人员资料数据分页
     */
    PageResult<TmglglrwzlDO> getTmglglrwzlPage(TmglglrwzlPageReqVO pageReqVO);

}