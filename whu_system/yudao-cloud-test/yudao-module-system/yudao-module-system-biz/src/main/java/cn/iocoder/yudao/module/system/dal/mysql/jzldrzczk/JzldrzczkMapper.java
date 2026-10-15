package cn.iocoder.yudao.module.system.dal.mysql.jzldrzczk;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrzczk.JzldrzczkDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrzczk.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 资产状况数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface JzldrzczkMapper extends BaseMapperX<JzldrzczkDO> {

    default PageResult<JzldrzczkDO> selectPage(JzldrzczkPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrzczkDO>()
                .likeIfPresent(JzldrzczkDO::getName, reqVO.getName())
                .likeIfPresent(JzldrzczkDO::getAssetType, reqVO.getAssetType())
                .orderByAsc(JzldrzczkDO::getName));
    }

}