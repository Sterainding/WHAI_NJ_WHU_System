package cn.iocoder.yudao.module.system.dal.mysql.mbsb;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.mbsb.MbsbDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.mbsb.vo.*;

/**
 * 红外目标识别数据 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MbsbMapper extends BaseMapperX<MbsbDO> {

    default PageResult<MbsbDO> selectPage(MbsbPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MbsbDO>()
                .eqIfPresent(MbsbDO::getId, reqVO.getId())
                .likeIfPresent(MbsbDO::getCountry, reqVO.getCountry())
                .likeIfPresent(MbsbDO::getTargetType, reqVO.getTargetType())
                .likeIfPresent(MbsbDO::getTargetModelNumber, reqVO.getTargetModelNumber())
                .orderByDesc(MbsbDO::getId));
    }

}