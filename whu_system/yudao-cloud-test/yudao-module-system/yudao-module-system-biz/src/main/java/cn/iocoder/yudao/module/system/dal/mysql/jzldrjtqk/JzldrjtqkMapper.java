package cn.iocoder.yudao.module.system.dal.mysql.jzldrjtqk;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrjtqk.JzldrjtqkDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrjtqk.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 家庭情况数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface JzldrjtqkMapper extends BaseMapperX<JzldrjtqkDO> {

    default PageResult<JzldrjtqkDO> selectPage(JzldrjtqkPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrjtqkDO>()
                .likeIfPresent(JzldrjtqkDO::getName, reqVO.getName())
                .likeIfPresent(JzldrjtqkDO::getFamilyMemberName, reqVO.getFamilyMemberName())
                .likeIfPresent(JzldrjtqkDO::getFamilyRelationship, reqVO.getFamilyRelationship())
                .orderByDesc(JzldrjtqkDO::getId));
    }

}