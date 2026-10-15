package cn.iocoder.yudao.module.system.controller.admin.jzldrshgx.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 社会关系数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrshgxRespVO {

    @Schema(description = "人物uid", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    @ExcelProperty("人物uid")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "社会成员名称", example = "demo")
    @ExcelProperty("社会成员名称")
    private String socialMemberName;

    @Schema(description = "社交活动圈子", example = "demo")
    @ExcelProperty("社交活动圈子")
    private String socialCircleName;

    @Schema(description = "关系类型")
    @ExcelProperty("关系类型")
    private String socialRelationship;

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