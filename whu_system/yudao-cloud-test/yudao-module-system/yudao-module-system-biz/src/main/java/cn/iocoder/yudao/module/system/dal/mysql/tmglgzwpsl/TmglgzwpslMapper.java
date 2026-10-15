package cn.iocoder.yudao.module.system.dal.mysql.tmglgzwpsl;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglgzwpsl.TmglgzwpslDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmglgzwpsl.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 购置物品及数量数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmglgzwpslMapper extends BaseMapperX<TmglgzwpslDO> {

    default PageResult<TmglgzwpslDO> selectPage(TmglgzwpslPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmglgzwpslDO>()
                .likeIfPresent(TmglgzwpslDO::getItemName, reqVO.getItemName())
                .orderByAsc(TmglgzwpslDO::getItemName));
    }

}