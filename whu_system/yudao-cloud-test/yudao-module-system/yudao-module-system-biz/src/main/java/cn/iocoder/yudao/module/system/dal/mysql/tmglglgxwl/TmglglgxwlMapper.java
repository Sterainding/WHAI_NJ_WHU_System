package cn.iocoder.yudao.module.system.dal.mysql.tmglglgxwl;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglglgxwl.TmglglgxwlDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmglglgxwl.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 关系网络数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmglglgxwlMapper extends BaseMapperX<TmglglgxwlDO> {

    default PageResult<TmglglgxwlDO> selectPage(TmglglgxwlPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmglglgxwlDO>()
                .likeIfPresent(TmglglgxwlDO::getName, reqVO.getName())
                .likeIfPresent(TmglglgxwlDO::getDirectSuperior, reqVO.getDirectSuperior())
                .orderByAsc(TmglglgxwlDO::getName));
    }

}