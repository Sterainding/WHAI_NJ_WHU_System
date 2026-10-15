package cn.iocoder.yudao.module.system.dal.mysql.jzldrrwbd;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwbd.JzldrrwbdDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrrwbd.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 人物报道数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface JzldrrwbdMapper extends BaseMapperX<JzldrrwbdDO> {

    default PageResult<JzldrrwbdDO> selectPage(JzldrrwbdPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrrwbdDO>()
                .likeIfPresent(JzldrrwbdDO::getName, reqVO.getName())
                .likeIfPresent(JzldrrwbdDO::getNewsTitle, reqVO.getNewsTitle())
                .orderByAsc(JzldrrwbdDO::getName));
    }

}