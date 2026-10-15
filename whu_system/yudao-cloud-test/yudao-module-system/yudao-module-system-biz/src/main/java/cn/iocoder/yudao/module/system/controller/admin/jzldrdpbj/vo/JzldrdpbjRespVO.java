package cn.iocoder.yudao.module.system.controller.admin.jzldrdpbj.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 党派背景数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrdpbjRespVO {

    @Schema(description = "党派背景id", example = "demo")
    @ExcelProperty("党派背景id")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "党派")
    @ExcelProperty("党派")
    private String politicalParty;

    @Schema(description = "党派政策")
    @ExcelProperty("党派政策")
    private String partyPolitics;

    @Schema(description = "入党时间")
    @ExcelProperty("入党时间")
    private String partyJoinDate;

    @Schema(description = "党内工作")
    @ExcelProperty("党内工作")
    private String partyJob;

    @Schema(description = "党派倾向")
    @ExcelProperty("党派倾向")
    private String partySide;

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

}