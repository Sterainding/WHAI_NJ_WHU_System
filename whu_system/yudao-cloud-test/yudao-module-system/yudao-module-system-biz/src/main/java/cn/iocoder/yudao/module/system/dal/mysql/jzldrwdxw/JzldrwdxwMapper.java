package cn.iocoder.yudao.module.system.dal.mysql.jzldrwdxw;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrwdxw.JzldrwdxwDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrwdxw.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
@InterceptorIgnore(tenantLine = "true")
/**
 * 污点新闻数据 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface JzldrwdxwMapper extends BaseMapperX<JzldrwdxwDO> {

    default PageResult<JzldrwdxwDO> selectPage(JzldrwdxwPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrwdxwDO>()
                .likeIfPresent(JzldrwdxwDO::getName, reqVO.getName())
                .likeIfPresent(JzldrwdxwDO::getRelNewsHea, reqVO.getRelNewsHea())
                .likeIfPresent(JzldrwdxwDO::getOccurrTime, reqVO.getOccurrTime())
                .likeIfPresent(JzldrwdxwDO::getSummarize, reqVO.getSummarize())
                .orderByAsc(JzldrwdxwDO::getName));
    }

}