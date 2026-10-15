package cn.iocoder.yudao.module.system.dal.mysql.tmglzkyjbg;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjbg.TmglzkyjbgDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmglzkyjbg.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 智库研究报告数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmglzkyjbgMapper extends BaseMapperX<TmglzkyjbgDO> {

    default PageResult<TmglzkyjbgDO> selectPage(TmglzkyjbgPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmglzkyjbgDO>()
                .betweenIfPresent(TmglzkyjbgDO::getPublishTime, reqVO.getPublishTime())
                .likeIfPresent(TmglzkyjbgDO::getAuthor, reqVO.getAuthor())
                .likeIfPresent(TmglzkyjbgDO::getReportName, reqVO.getReportName())
                .likeIfPresent(TmglzkyjbgDO::getKeywords, reqVO.getKeywords())
                .orderByDesc(TmglzkyjbgDO::getPublishTime));
    }

}