package cn.iocoder.yudao.module.system.controller.admin.jzldrwdxw.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 污点新闻数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrwdxwRespVO {

    @Schema(description = "污点新闻id", example = "demo")
    @ExcelProperty("污点新闻id")
    private String id;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String rwid;

    @Schema(description = "姓名", example = "demo")
    @ExcelProperty("姓名")
    private String name;

    @Schema(description = "新闻标题")
    @ExcelProperty("新闻标题")
    private String relNewsHea;

    @Schema(description = "出现时间")
    @ExcelProperty("出现时间")
    private String occurrTime;

    @Schema(description = "内容总结")
    @ExcelProperty("内容总结")
    private String summarize;

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

    @Schema(description = "发布时间")
    @ExcelProperty("发布时间")
    private String publishTime;

    @Schema(description = "美参众两院对丑闻的言论态度")
    @ExcelProperty("美参众两院对丑闻的言论态度")
    private String sHRAttitudesToScandal;

}