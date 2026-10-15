package cn.iocoder.yudao.module.system.controller.admin.tmgltmdxryhd.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 人员活动数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TmgltmdxryhdRespVO {

    @Schema(description = "数据标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    @ExcelProperty("数据标识")
    private String id;

    @Schema(description = "发布时间")
    @ExcelProperty("发布时间")
    private String pushTime;

    @Schema(description = "发布单位/渠道")
    @ExcelProperty("发布单位/渠道")
    private String pushChannel;

    @Schema(description = "事件名称")
    @ExcelProperty("事件名称")
    private String eventTitle;

    @Schema(description = "参与人员")
    @ExcelProperty("参与人员")
    private String participant;

    @Schema(description = "涉及单位")
    @ExcelProperty("涉及单位")
    private String relatedPublish;

    @Schema(description = "活动地点")
    @ExcelProperty("活动地点")
    private String eventLocation;

    @Schema(description = "活动时间")
    @ExcelProperty("活动时间")
    private String eventTime;

    @Schema(description = "事件影响")
    @ExcelProperty("事件影响")
    private String impact;

    @Schema(description = "相关评论")
    @ExcelProperty("相关评论")
    private String relatedComments;

    @Schema(description = "数据来源")
    @ExcelProperty("数据来源")
    private String eventContent;

    @Schema(description = "数据来源")
    @ExcelProperty("数据来源")
    private String source;

    @Schema(description = "审阅状态")
    @ExcelProperty("审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    @ExcelProperty("原网页")
    private String sourceNet;

    @Schema(description = "更新时间")
    @ExcelProperty("更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    @ExcelProperty("国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    @ExcelProperty("国家（地区）名称")
    private String countryRegionName;

}