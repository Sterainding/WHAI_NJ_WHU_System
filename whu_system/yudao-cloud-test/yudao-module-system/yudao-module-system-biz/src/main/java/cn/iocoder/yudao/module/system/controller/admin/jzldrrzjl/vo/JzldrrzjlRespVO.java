package cn.iocoder.yudao.module.system.controller.admin.jzldrrzjl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 任职经历数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrrzjlRespVO {

    @Schema(description = "任职经历id", example = "demo")
    @ExcelProperty("任职经历id")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "任职id", example = "demo")
    @ExcelProperty("任职id")
    private String rzid;

    @Schema(description = "参加工作时间")
    @ExcelProperty("参加工作时间")
    private String employmentTime;

    @Schema(description = "工作状态（现职/退休）")
    @ExcelProperty("工作状态（现职/退休）")
    private String employmentState;

    @Schema(description = "机构名称", example = "demo")
    @ExcelProperty("机构名称")
    private String institutionName;

    @Schema(description = "职务")
    @ExcelProperty("职务")
    private String position;

    @Schema(description = "任职时间")
    @ExcelProperty("任职时间")
    private String jobTime;

    @Schema(description = "工作地点")
    @ExcelProperty("工作地点")
    private String workLocation;

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

}