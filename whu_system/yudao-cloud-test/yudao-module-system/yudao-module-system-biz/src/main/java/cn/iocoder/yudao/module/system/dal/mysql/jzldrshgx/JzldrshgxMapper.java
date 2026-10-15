package cn.iocoder.yudao.module.system.dal.mysql.jzldrshgx;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrshgx.JzldrshgxDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrshgx.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
@InterceptorIgnore(tenantLine = "true")
/**
 * 社会关系数据 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface JzldrshgxMapper extends BaseMapperX<JzldrshgxDO> {

    default PageResult<JzldrshgxDO> selectPage(JzldrshgxPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrshgxDO>()
                .likeIfPresent(JzldrshgxDO::getName, reqVO.getName())
                .likeIfPresent(JzldrshgxDO::getSocialMemberName, reqVO.getSocialMemberName())
                .likeIfPresent(JzldrshgxDO::getSocialCircleName, reqVO.getSocialCircleName())
                .likeIfPresent(JzldrshgxDO::getSocialRelationship, reqVO.getSocialRelationship())
                .orderByAsc(JzldrshgxDO::getName));
    }

}