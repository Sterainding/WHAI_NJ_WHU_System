package cn.iocoder.yudao.module.system.controller.admin.jzldrrwdx.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 人物动向数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrrwdxRespVO {

    @Schema(description = "人物id", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "人物动向id", example = "demo")
    @ExcelProperty("人物动向id")
    private String uid;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "动向标题")
    @ExcelProperty("动向标题")
    private String actionTopic;

    @Schema(description = "动向时间")
    @ExcelProperty("动向时间")
    private String actionTime;

    @Schema(description = "动向地点")
    @ExcelProperty("动向地点")
    private String actionPlace;

    @Schema(description = "合作成员名单")
    @ExcelProperty("合作成员名单")
    private String companyMembersList;

    @Schema(description = "描述", example = "demo")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "数据来源")
    @ExcelProperty("数据来源")
    private String source;

    @Schema(description = "更新时间")
    @ExcelProperty("更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    @ExcelProperty("国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    @ExcelProperty("国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "发布时间")
    @ExcelProperty("发布时间")
    private String publishTime;

    @Schema(description = "审阅状态")
    @ExcelProperty("审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    @ExcelProperty("原网页")
    private String sourceNet;

}