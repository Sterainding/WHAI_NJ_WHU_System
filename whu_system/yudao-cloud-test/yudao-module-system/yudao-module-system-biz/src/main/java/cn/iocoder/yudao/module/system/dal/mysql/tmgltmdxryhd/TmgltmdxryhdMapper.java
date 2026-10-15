package cn.iocoder.yudao.module.system.dal.mysql.tmgltmdxryhd;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxryhd.TmgltmdxryhdDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmdxryhd.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 人员活动数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmgltmdxryhdMapper extends BaseMapperX<TmgltmdxryhdDO> {

    default PageResult<TmgltmdxryhdDO> selectPage(TmgltmdxryhdPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmgltmdxryhdDO>()
                .betweenIfPresent(TmgltmdxryhdDO::getPushTime, reqVO.getPushTime())
                .likeIfPresent(TmgltmdxryhdDO::getPushChannel, reqVO.getPushChannel())
                .likeIfPresent(TmgltmdxryhdDO::getRelatedPublish, reqVO.getRelatedPublish())
                .likeIfPresent(TmgltmdxryhdDO::getEventLocation, reqVO.getEventLocation())
                .betweenIfPresent(TmgltmdxryhdDO::getEventTime, reqVO.getEventTime())
                .orderByDesc(TmgltmdxryhdDO::getEventTime));
    }

}