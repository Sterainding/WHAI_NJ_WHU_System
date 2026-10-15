package cn.iocoder.yudao.module.system.dal.mysql.hwtxzcystxzc;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcystxzc.HwtxzcystxzcDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.hwtxzcystxzc.vo.*;

import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 红外原始图像侦察数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface HwtxzcystxzcMapper extends BaseMapperX<HwtxzcystxzcDO> {

    default PageResult<HwtxzcystxzcDO> selectPage(HwtxzcystxzcPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<HwtxzcystxzcDO>()
                .likeIfPresent(HwtxzcystxzcDO::getCountryRegionName, reqVO.getCountryRegionName())
                .likeIfPresent(HwtxzcystxzcDO::getFileName, reqVO.getFileName())
                .eqIfPresent(HwtxzcystxzcDO::getFileType, reqVO.getFileType())
                .eqIfPresent(HwtxzcystxzcDO::getFileFormat, reqVO.getFileFormat())
                .likeIfPresent(HwtxzcystxzcDO::getSensorType, reqVO.getSensorType())
                .orderByDesc(HwtxzcystxzcDO::getId));
    }

}