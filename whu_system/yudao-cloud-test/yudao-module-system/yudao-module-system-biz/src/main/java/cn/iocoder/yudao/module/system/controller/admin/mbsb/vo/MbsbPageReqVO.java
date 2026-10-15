package cn.iocoder.yudao.module.system.controller.admin.mbsb.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 红外目标识别数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MbsbPageReqVO extends PageParam {

    @Schema(description = "目标标识")
    private String id;

    @Schema(description = "拍摄国家及地区	")
    private String country;

    @Schema(description = "目标类型")
    private String targetType;

    @Schema(description = "目标型号")
    private String targetModelNumber;

}