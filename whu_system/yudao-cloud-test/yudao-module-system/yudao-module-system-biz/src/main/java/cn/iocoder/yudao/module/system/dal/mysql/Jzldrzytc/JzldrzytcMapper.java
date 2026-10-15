package cn.iocoder.yudao.module.system.dal.mysql.Jzldrzytc;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.Jzldrzytc.JzldrzytcDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.Jzldrzytc.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
@InterceptorIgnore(tenantLine = "true")
/**
 * 专业特长数据 Mapper
 *
 * @author 芋道源码
 */

@Mapper
public interface JzldrzytcMapper extends BaseMapperX<JzldrzytcDO> {

    default PageResult<JzldrzytcDO> selectPage(JzldrzytcPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrzytcDO>()
                .likeIfPresent(JzldrzytcDO::getName, reqVO.getName())
                .likeIfPresent(JzldrzytcDO::getFuncArea, reqVO.getFuncArea())
                .likeIfPresent(JzldrzytcDO::getProfesTecPos, reqVO.getProfesTecPos())
                .orderByAsc(JzldrzytcDO::getName));
    }

}