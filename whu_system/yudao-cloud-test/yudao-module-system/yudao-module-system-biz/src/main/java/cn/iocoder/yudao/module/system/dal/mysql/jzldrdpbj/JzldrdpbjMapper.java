package cn.iocoder.yudao.module.system.dal.mysql.jzldrdpbj;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrdpbj.JzldrdpbjDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrdpbj.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 党派背景数据 Mapper
 *
 * @author 芋道源码
 */
@InterceptorIgnore(tenantLine = "true")
@Mapper
public interface JzldrdpbjMapper extends BaseMapperX<JzldrdpbjDO> {

    default PageResult<JzldrdpbjDO> selectPage(JzldrdpbjPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrdpbjDO>()
                .likeIfPresent(JzldrdpbjDO::getName, reqVO.getName())
                .likeIfPresent(JzldrdpbjDO::getPoliticalParty, reqVO.getPoliticalParty())
                .likeIfPresent(JzldrdpbjDO::getPartyJob, reqVO.getPartyJob())
                .orderByAsc(JzldrdpbjDO::getName));
    }

}