package cn.iocoder.yudao.module.system.dal.mysql.tmglglrwzl;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.tmglglrwzl.TmglglrwzlDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.tmglglrwzl.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 人员资料数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface TmglglrwzlMapper extends BaseMapperX<TmglglrwzlDO> {

    default PageResult<TmglglrwzlDO> selectPage(TmglglrwzlPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TmglglrwzlDO>()
                .likeIfPresent(TmglglrwzlDO::getName, reqVO.getName())
                .likeIfPresent(TmglglrwzlDO::getCountryRegionName, reqVO.getCountryRegionName())
                .likeIfPresent(TmglglrwzlDO::getSex, reqVO.getSex())
                .likeIfPresent(TmglglrwzlDO::getPartisan, reqVO.getPartisan())
                .likeIfPresent(TmglglrwzlDO::getPosition, reqVO.getPosition())
                .orderByAsc(TmglglrwzlDO::getName));
    }

}