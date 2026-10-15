package cn.iocoder.yudao.module.system.service.jzldrrwdx;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwdx.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwdx.JzldrrwdxDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 人物动向数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrrwdxService {

    /**
     * 创建人物动向数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrrwdx(@Valid JzldrrwdxSaveReqVO createReqVO);

    /**
     * 更新人物动向数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrrwdx(@Valid JzldrrwdxSaveReqVO updateReqVO);

    /**
     * 删除人物动向数据
     *
     * @param id 编号
     */
    void deleteJzldrrwdx(String id);

    /**
     * 获得人物动向数据
     *
     * @param id 编号
     * @return 人物动向数据
     */
    JzldrrwdxDO getJzldrrwdx(String id);

    /**
     * 获得人物动向数据分页
     *
     * @param pageReqVO 分页查询
     * @return 人物动向数据分页
     */
    PageResult<JzldrrwdxDO> getJzldrrwdxPage(JzldrrwdxPageReqVO pageReqVO);

}