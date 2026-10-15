package cn.iocoder.yudao.module.system.dal.mysql.tmgltmfwys;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmfwys.TmgltmfwysDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmfwys.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 台美防务预算数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmgltmfwysMapper extends BaseMapperX<TmgltmfwysDO> {

    default PageResult<TmgltmfwysDO> selectPage(TmgltmfwysPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmgltmfwysDO>()
                .likeIfPresent(TmgltmfwysDO::getBudgetPulisher, reqVO.getBudgetPulisher())
                .likeIfPresent(TmgltmfwysDO::getBudgetFlowTo, reqVO.getBudgetFlowTo())
                .likeIfPresent(TmgltmfwysDO::getPublishTime, reqVO.getPublishTime())
                .orderByDesc(TmgltmfwysDO::getPublishTime));
    }

}