package cn.iocoder.yudao.module.system.controller.admin.tmgltmdxryhd.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 人员活动数据新增/修改 Request VO")
@Data
public class TmgltmdxryhdSaveReqVO {

    @Schema(description = "数据标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    private String id;

    @Schema(description = "发布时间")
    private String pushTime;

    @Schema(description = "发布单位/渠道")
    private String pushChannel;

    @Schema(description = "事件名称")
    private String eventTitle;

    @Schema(description = "参与人员")
    private String participant;

    @Schema(description = "涉及单位")
    private String relatedPublish;

    @Schema(description = "活动地点")
    private String eventLocation;

    @Schema(description = "活动时间")
    private String eventTime;

    @Schema(description = "事件影响")
    private String impact;

    @Schema(description = "相关评论")
    private String relatedComments;

    @Schema(description = "数据来源")
    private String eventContent;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "原网页")
    private String sourceNet;

}