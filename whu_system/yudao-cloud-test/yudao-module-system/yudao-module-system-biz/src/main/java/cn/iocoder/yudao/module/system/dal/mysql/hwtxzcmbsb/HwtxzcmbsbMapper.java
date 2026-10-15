package cn.iocoder.yudao.module.system.dal.mysql.hwtxzcmbsb;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcmbsb.HwtxzcmbsbDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.hwtxzcmbsb.vo.*;

/**
 * 红外目标识别数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface HwtxzcmbsbMapper extends BaseMapperX<HwtxzcmbsbDO> {

    default PageResult<HwtxzcmbsbDO> selectPage(HwtxzcmbsbPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<HwtxzcmbsbDO>()
                .likeIfPresent(HwtxzcmbsbDO::getCountryRegionName, reqVO.getCountryRegionName())
                .likeIfPresent(HwtxzcmbsbDO::getTargetType, reqVO.getTargetType())
                .orderByDesc(HwtxzcmbsbDO::getId));
    }

}