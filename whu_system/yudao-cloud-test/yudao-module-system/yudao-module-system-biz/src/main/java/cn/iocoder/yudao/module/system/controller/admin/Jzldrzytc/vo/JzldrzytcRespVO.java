package cn.iocoder.yudao.module.system.controller.admin.Jzldrzytc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 专业特长数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrzytcRespVO {

    @Schema(description = "专业特长id", example = "demo")
    @ExcelProperty("专业特长id")
    private String id;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String rwid;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "专业领域")
    @ExcelProperty("专业领域")
    private String funcArea;

    @Schema(description = "专业领域描述")
    @ExcelProperty("专业领域描述")
    private String funcAreaDes;

    @Schema(description = "领域主张")
    @ExcelProperty("领域主张")
    private String funcAreaAdv;

    @Schema(description = "领域职位")
    @ExcelProperty("领域职位")
    private String profesTecPos;

    @Schema(description = "最新动向")
    @ExcelProperty("最新动向")
    private String direction;

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