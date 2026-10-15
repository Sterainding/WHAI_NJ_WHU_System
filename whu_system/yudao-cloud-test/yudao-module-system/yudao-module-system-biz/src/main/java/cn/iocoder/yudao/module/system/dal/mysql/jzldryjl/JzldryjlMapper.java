package cn.iocoder.yudao.module.system.dal.mysql.jzldryjl;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldryjl.JzldryjlDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldryjl.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 教育经历数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface JzldryjlMapper extends BaseMapperX<JzldryjlDO> {

    default PageResult<JzldryjlDO> selectPage(JzldryjlPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldryjlDO>()
                .eqIfPresent(JzldryjlDO::getUid, reqVO.getUid())
                .likeIfPresent(JzldryjlDO::getName, reqVO.getName())
                .likeIfPresent(JzldryjlDO::getGraduatedSchool, reqVO.getGraduatedSchool())
                .likeIfPresent(JzldryjlDO::getEducationLevel, reqVO.getEducationLevel())
                .orderByAsc(JzldryjlDO::getName));
    }

}