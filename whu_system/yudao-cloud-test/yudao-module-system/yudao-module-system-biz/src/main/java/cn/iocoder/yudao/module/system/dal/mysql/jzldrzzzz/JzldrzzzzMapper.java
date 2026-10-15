package cn.iocoder.yudao.module.system.dal.mysql.jzldrzzzz;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrzzzz.JzldrzzzzDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrzzzz.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
@InterceptorIgnore(tenantLine = "true")
/**
 * 政治主张数据 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface JzldrzzzzMapper extends BaseMapperX<JzldrzzzzDO> {

    default PageResult<JzldrzzzzDO> selectPage(JzldrzzzzPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrzzzzDO>()
                .eqIfPresent(JzldrzzzzDO::getUid, reqVO.getUid())
                .likeIfPresent(JzldrzzzzDO::getName, reqVO.getName())
                .likeIfPresent(JzldrzzzzDO::getInvolvedField, reqVO.getInvolvedField())
                .likeIfPresent(JzldrzzzzDO::getPoliticsTags, reqVO.getPoliticsTags())
                .orderByAsc(JzldrzzzzDO::getName));
    }

}