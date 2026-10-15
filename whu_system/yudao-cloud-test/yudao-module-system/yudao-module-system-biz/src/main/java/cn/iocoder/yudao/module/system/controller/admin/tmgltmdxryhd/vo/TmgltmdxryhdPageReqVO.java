package cn.iocoder.yudao.module.system.controller.admin.tmgltmdxryhd.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 人员活动数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmgltmdxryhdPageReqVO extends PageParam {

    @Schema(description = "发布时间")
    private String[] pushTime;

    @Schema(description = "发布单位/渠道")
    private String pushChannel;

    @Schema(description = "涉及单位")
    private String relatedPublish;

    @Schema(description = "活动地点")
    private String eventLocation;

    @Schema(description = "活动时间")
    private String[] eventTime;

}