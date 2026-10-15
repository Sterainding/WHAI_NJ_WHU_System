package cn.iocoder.yudao.module.system.service.jzldrwdxw;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrwdxw.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrwdxw.JzldrwdxwDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 污点新闻数据 Service 接口
 *
 * @author 芋道源码
 */
public interface JzldrwdxwService {

    /**
     * 创建污点新闻数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createJzldrwdxw(@Valid JzldrwdxwSaveReqVO createReqVO);

    /**
     * 更新污点新闻数据
     *
     * @param updateReqVO 更新信息
     */
    void updateJzldrwdxw(@Valid JzldrwdxwSaveReqVO updateReqVO);

    /**
     * 删除污点新闻数据
     *
     * @param id 编号
     */
    void deleteJzldrwdxw(String id);

    /**
     * 获得污点新闻数据
     *
     * @param id 编号
     * @return 污点新闻数据
     */
    JzldrwdxwDO getJzldrwdxw(String id);

    /**
     * 获得污点新闻数据分页
     *
     * @param pageReqVO 分页查询
     * @return 污点新闻数据分页
     */
    PageResult<JzldrwdxwDO> getJzldrwdxwPage(JzldrwdxwPageReqVO pageReqVO);

}