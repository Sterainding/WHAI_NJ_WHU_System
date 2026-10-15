package cn.iocoder.yudao.module.system.controller.admin.hwtxzcmbsb.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 红外目标识别数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HwtxzcmbsbPageReqVO extends PageParam {

    @Schema(description = "拍摄国家及地区	")
    private String countryRegionName;

    @Schema(description = "目标类型")
    private String targetType;

}