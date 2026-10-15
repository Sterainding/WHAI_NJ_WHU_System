package cn.iocoder.yudao.module.system.controller.admin.jzldrsjzh.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 社交账号数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class jzldrsjzhRespVO {

    @Schema(description = "人物uid", example = "demo")
    @ExcelProperty("人物uid")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String rwid;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "社交平台")
    @ExcelProperty("社交平台")
    private String platform;

    @Schema(description = "社交账号", example = "demo")
    @ExcelProperty("社交账号")
    private String account;

    @Schema(description = "发布内容")
    @ExcelProperty("发布内容")
    private String postContent;

    @Schema(description = "发布时间")
    @ExcelProperty("发布时间")
    private String postTime;

    @Schema(description = "粉丝数")
    @ExcelProperty("粉丝数")
    private String fans;

    @Schema(description = "订阅数")
    @ExcelProperty("订阅数")
    private String subscribe;

    @Schema(description = "评论数")
    @ExcelProperty("评论数")
    private String comment;

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

    @Schema(description = "转发量")
    @ExcelProperty("转发量")
    private String repost;

}