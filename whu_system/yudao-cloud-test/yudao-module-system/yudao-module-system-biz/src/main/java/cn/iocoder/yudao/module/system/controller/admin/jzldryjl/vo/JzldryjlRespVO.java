package cn.iocoder.yudao.module.system.controller.admin.jzldryjl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 教育经历数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldryjlRespVO {

    @Schema(description = "教育经历id", example = "demo")
    @ExcelProperty("教育经历id")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "人物教育经历编号", example = "demo")
    @ExcelProperty("人物教育经历编号")
    private String jyid;

    @Schema(description = "毕业院校")
    @ExcelProperty("毕业院校")
    private String graduatedSchool;

    @Schema(description = "学位")
    @ExcelProperty("学位")
    private String degree;

    @Schema(description = "学历")
    @ExcelProperty("学历")
    private String educationLevel;

    @Schema(description = "专业")
    @ExcelProperty("专业")
    private String major;

    @Schema(description = "论文")
    @ExcelProperty("论文")
    private String paperList;

    @Schema(description = "描述", example = "demo")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "数据来源")
    @ExcelProperty("数据来源")
    private String source;

    @Schema(description = "审阅状态")
    @ExcelProperty("审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    @ExcelProperty("原网页")
    private String sourceNet;

}