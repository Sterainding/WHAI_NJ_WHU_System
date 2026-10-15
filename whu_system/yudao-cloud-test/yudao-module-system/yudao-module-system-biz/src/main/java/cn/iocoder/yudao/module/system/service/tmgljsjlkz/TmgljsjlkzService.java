package cn.iocoder.yudao.module.system.service.tmgljsjlkz;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.tmgljsjlkz.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgljsjlkz.TmgljsjlkzDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 军事交流项目和开支数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TmgljsjlkzService {

    /**
     * 创建军事交流项目和开支数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createTmgljsjlkz(@Valid TmgljsjlkzSaveReqVO createReqVO);

    /**
     * 更新军事交流项目和开支数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTmgljsjlkz(@Valid TmgljsjlkzSaveReqVO updateReqVO);

    /**
     * 删除军事交流项目和开支数据
     *
     * @param id 编号
     */
    void deleteTmgljsjlkz(String id);

    /**
     * 获得军事交流项目和开支数据
     *
     * @param id 编号
     * @return 军事交流项目和开支数据
     */
    TmgljsjlkzDO getTmgljsjlkz(String id);

    /**
     * 获得军事交流项目和开支数据分页
     *
     * @param pageReqVO 分页查询
     * @return 军事交流项目和开支数据分页
     */
    PageResult<TmgljsjlkzDO> getTmgljsjlkzPage(TmgljsjlkzPageReqVO pageReqVO);

}