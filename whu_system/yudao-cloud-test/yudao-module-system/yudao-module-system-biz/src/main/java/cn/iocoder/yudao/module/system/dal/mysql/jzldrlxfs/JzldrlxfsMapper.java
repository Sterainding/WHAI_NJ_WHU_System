package cn.iocoder.yudao.module.system.dal.mysql.jzldrlxfs;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrlxfs.JzldrlxfsDO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.jzldrlxfs.vo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")

@InterceptorIgnore(tenantLine = "true")
/**
 * 联系方式数据 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface JzldrlxfsMapper extends BaseMapperX<JzldrlxfsDO> {

    default PageResult<JzldrlxfsDO> selectPage(JzldrlxfsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JzldrlxfsDO>()
                .likeIfPresent(JzldrlxfsDO::getName, reqVO.getName())
                .likeIfPresent(JzldrlxfsDO::getSocialMediaAccount, reqVO.getSocialMediaAccount())
                .orderByAsc(JzldrlxfsDO::getId));
    }

}