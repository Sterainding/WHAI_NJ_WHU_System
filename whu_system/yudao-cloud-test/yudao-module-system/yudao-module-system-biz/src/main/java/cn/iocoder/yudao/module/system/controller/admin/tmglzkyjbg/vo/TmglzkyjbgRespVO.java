package cn.iocoder.yudao.module.system.controller.admin.tmglzkyjbg.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 智库研究报告数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TmglzkyjbgRespVO {

    @Schema(description = "数据标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("数据标识")
    private String id;

    @Schema(description = "发布日期")
    @ExcelProperty("发布日期")
    private String publishTime;

    @Schema(description = "发布机构")
    @ExcelProperty("发布机构")
    private String publishAgency;

    @Schema(description = "发布作者")
    @ExcelProperty("发布作者")
    private String author;

    @Schema(description = "作者背景")
    @ExcelProperty("作者背景")
    private String authorBackground;

    @Schema(description = "涉及问题")
    @ExcelProperty("涉及问题")
    private String about;

    @Schema(description = "报告名称")
    @ExcelProperty("报告名称")
    private String reportName;

    @Schema(description = "报告影响评估")
    @ExcelProperty("报告影响评估")
    private String influence;

    @Schema(description = "报告内容")
    @ExcelProperty("报告内容")
    private String content;

    @Schema(description = "报告关键词")
    @ExcelProperty("报告关键词")
    private String keywords;

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