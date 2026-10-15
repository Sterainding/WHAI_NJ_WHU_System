package cn.iocoder.yudao.module.system.dal.mysql.jzldrrzjl;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrzjl.JzldrrzjlDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrzjl.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
@InterceptorIgnore(tenantLine = "true")
/**
 * 任职经历数据 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface JzldrrzjlMapper extends BaseMapperX<JzldrrzjlDO> {

    default PageResult<JzldrrzjlDO> selectPage(JzldrrzjlPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrrzjlDO>()
                .likeIfPresent(JzldrrzjlDO::getName, reqVO.getName())
                .likeIfPresent(JzldrrzjlDO::getInstitutionName, reqVO.getInstitutionName())
                .likeIfPresent(JzldrrzjlDO::getWorkLocation, reqVO.getWorkLocation())
                .orderByAsc(JzldrrzjlDO::getName));
    }

}