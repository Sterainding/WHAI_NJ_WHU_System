package cn.iocoder.yudao.module.system.dal.mysql.jzldrsjzh;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrsjzh.jzldrsjzhDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrsjzh.vo.*;

/**
 * 社交账号数据 Mapper
 *
 * @author 芋道源码
 */

import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface jzldrsjzhMapper extends BaseMapperX<jzldrsjzhDO> {

    default PageResult<jzldrsjzhDO> selectPage(jzldrsjzhPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<jzldrsjzhDO>()
                .likeIfPresent(jzldrsjzhDO::getName, reqVO.getName())
                .likeIfPresent(jzldrsjzhDO::getPlatform, reqVO.getPlatform())
                .orderByAsc(jzldrsjzhDO::getName));
    }

}