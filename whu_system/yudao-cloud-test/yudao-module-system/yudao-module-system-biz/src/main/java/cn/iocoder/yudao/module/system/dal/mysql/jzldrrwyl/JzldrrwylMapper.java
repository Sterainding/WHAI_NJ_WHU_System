package cn.iocoder.yudao.module.system.dal.mysql.jzldrrwyl;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwyl.JzldrrwylDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwyl.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")

@InterceptorIgnore(tenantLine = "true")
/**
 * 人物言论 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface JzldrrwylMapper extends BaseMapperX<JzldrrwylDO> {

    default PageResult<JzldrrwylDO> selectPage(JzldrrwylPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrrwylDO>()
                .likeIfPresent(JzldrrwylDO::getName, reqVO.getName())
                .likeIfPresent(JzldrrwylDO::getIssueContent, reqVO.getIssueContent())
                .betweenIfPresent(JzldrrwylDO::getIssuePublishTime, reqVO.getIssuePublishTime())
                .orderByAsc(JzldrrwylDO::getName));
    }

}