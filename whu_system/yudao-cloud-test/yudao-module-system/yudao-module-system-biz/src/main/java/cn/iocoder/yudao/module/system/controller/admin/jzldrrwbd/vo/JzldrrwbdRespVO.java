package cn.iocoder.yudao.module.system.controller.admin.jzldrrwbd.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 人物报道数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrrwbdRespVO {

    @Schema(description = "人物报道id", example = "demo")
    @ExcelProperty("人物报道id")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "新闻内容")
    @ExcelProperty("新闻内容")
    private String newsContent;

    @Schema(description = "新闻标题")
    @ExcelProperty("新闻标题")
    private String newsTitle;

    @Schema(description = "新闻发布时间")
    @ExcelProperty("新闻发布时间")
    private String newsPublishTime;

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