package cn.iocoder.yudao.module.system.controller.admin.jzldrrwyl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 人物言论 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrrwylRespVO {

    @Schema(description = "人物言论id", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    @ExcelProperty("人物言论id")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "言论内容")
    @ExcelProperty("言论内容")
    private String issueContent;

    @Schema(description = "言论情况")
    @ExcelProperty("言论情况")
    private String issueSituation;

    @Schema(description = "言论发布时间")
    @ExcelProperty("言论发布时间")
    private String issuePublishTime;

    @Schema(description = "发布类型", example = "demo")
    @ExcelProperty("发布类型")
    private String publishType;

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

    @Schema(description = "审阅状态")
    @ExcelProperty("审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    @ExcelProperty("原网页")
    private String sourceNet;

}