package cn.iocoder.yudao.module.system.controller.admin.jzldrzzzz.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 政治主张数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrzzzzRespVO {

    @Schema(description = "人物uid", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    @ExcelProperty("人物uid")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "涉及领域")
    @ExcelProperty("涉及领域")
    private String involvedField;

    @Schema(description = "政治主张")
    @ExcelProperty("政治主张")
    private String politicsContent;

    @Schema(description = "政治标签")
    @ExcelProperty("政治标签")
    private String politicsTags;

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

    @Schema(description = "对华态度")
    @ExcelProperty("对华态度")
    private String attitude;

}