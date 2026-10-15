package cn.iocoder.yudao.module.system.dal.mysql.tmgltmdxjs;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxjs.TmgltmdxjsDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmgltmdxjs.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 军售数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmgltmdxjsMapper extends BaseMapperX<TmgltmdxjsDO> {

    default PageResult<TmgltmdxjsDO> selectPage(TmgltmdxjsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmgltmdxjsDO>()
                .likeIfPresent(TmgltmdxjsDO::getSaleDepartment, reqVO.getSaleDepartment())
                .likeIfPresent(TmgltmdxjsDO::getBuyDepartment, reqVO.getBuyDepartment())
                .likeIfPresent(TmgltmdxjsDO::getDealLocation, reqVO.getDealLocation())
                .likeIfPresent(TmgltmdxjsDO::getWeaponTypeNum, reqVO.getWeaponTypeNum())
                .orderByAsc(TmgltmdxjsDO::getBuyDepartment));
    }

}