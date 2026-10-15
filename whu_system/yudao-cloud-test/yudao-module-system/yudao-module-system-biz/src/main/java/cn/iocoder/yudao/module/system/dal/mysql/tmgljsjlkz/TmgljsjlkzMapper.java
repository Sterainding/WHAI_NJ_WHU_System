package cn.iocoder.yudao.module.system.dal.mysql.tmgljsjlkz;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgljsjlkz.TmgljsjlkzDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmgljsjlkz.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 军事交流项目和开支数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmgljsjlkzMapper extends BaseMapperX<TmgljsjlkzDO> {

    default PageResult<TmgljsjlkzDO> selectPage(TmgljsjlkzPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmgljsjlkzDO>()
                .likeIfPresent(TmgljsjlkzDO::getName, reqVO.getName())
                .likeIfPresent(TmgljsjlkzDO::getArea, reqVO.getArea())
                .eqIfPresent(TmgljsjlkzDO::getLeadingCountry, reqVO.getLeadingCountry())
                .likeIfPresent(TmgljsjlkzDO::getMilitaryBranch, reqVO.getMilitaryBranch())
                .orderByAsc(TmgljsjlkzDO::getName));
    }

}