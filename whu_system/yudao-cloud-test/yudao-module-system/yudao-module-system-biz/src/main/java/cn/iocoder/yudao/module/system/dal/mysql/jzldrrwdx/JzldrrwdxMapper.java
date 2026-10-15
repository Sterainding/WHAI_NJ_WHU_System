package cn.iocoder.yudao.module.system.dal.mysql.jzldrrwdx;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwdx.JzldrrwdxDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwdx.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 人物动向数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface JzldrrwdxMapper extends BaseMapperX<JzldrrwdxDO> {

    default PageResult<JzldrrwdxDO> selectPage(JzldrrwdxPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrrwdxDO>()
                .likeIfPresent(JzldrrwdxDO::getName, reqVO.getName())
                .likeIfPresent(JzldrrwdxDO::getActionTime, reqVO.getActionTime())
                .likeIfPresent(JzldrrwdxDO::getActionPlace, reqVO.getActionPlace())
                .orderByAsc(JzldrrwdxDO::getName));
    }

}