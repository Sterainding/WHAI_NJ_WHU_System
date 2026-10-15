package cn.iocoder.yudao.module.system.dal.mysql.tmglzkyjrybj;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjrybj.TmglzkyjrybjDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmglzkyjrybj.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 智库研究员背景数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmglzkyjrybjMapper extends BaseMapperX<TmglzkyjrybjDO> {

    default PageResult<TmglzkyjrybjDO> selectPage(TmglzkyjrybjPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmglzkyjrybjDO>()
                .likeIfPresent(TmglzkyjrybjDO::getEducationLevel, reqVO.getEducationLevel())
                .orderByDesc(TmglzkyjrybjDO::getId));
    }

}