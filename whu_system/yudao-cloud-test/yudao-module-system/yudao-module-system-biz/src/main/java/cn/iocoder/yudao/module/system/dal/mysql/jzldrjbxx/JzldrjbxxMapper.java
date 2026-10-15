package cn.iocoder.yudao.module.system.dal.mysql.jzldrjbxx;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrjbxx.JzldrjbxxDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrjbxx.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 基本信息数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface JzldrjbxxMapper extends BaseMapperX<JzldrjbxxDO> {

//    default PageResult<JzldrjbxxDO> selectPage(JzldrjbxxPageReqVO reqVO) {
//        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrjbxxDO>()
//                .likeIfPresent(JzldrjbxxDO::getName, reqVO.getName())
//                .likeIfPresent(JzldrjbxxDO::getCountry, reqVO.getCountry())
//                .likeIfPresent(JzldrjbxxDO::getMilitaryBranch, reqVO.getMilitaryBranch())
//                .likeIfPresent(JzldrjbxxDO::getMilitaryRank, reqVO.getMilitaryRank())
//                .likeIfPresent(JzldrjbxxDO::getEthnicity, reqVO.getEthnicity())
//                .orderByAsc(JzldrjbxxDO::getName))
//                .orderByAsc(JzldrjbxxDO::getCountry);
//    }
    default PageResult<JzldrjbxxDO> selectPage(JzldrjbxxPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrjbxxDO>()
                .likeIfPresent(JzldrjbxxDO::getName, reqVO.getName())
                .likeIfPresent(JzldrjbxxDO::getCountryRegionName, reqVO.getCountryRegionName())
                .likeIfPresent(JzldrjbxxDO::getMilitaryBranch, reqVO.getMilitaryBranch())
                .likeIfPresent(JzldrjbxxDO::getMilitaryRank, reqVO.getMilitaryRank())
                .likeIfPresent(JzldrjbxxDO::getEthnicity, reqVO.getEthnicity())
                .orderByAsc(JzldrjbxxDO::getCountryRegionName)
                .orderByAsc(JzldrjbxxDO::getName));
    }

}