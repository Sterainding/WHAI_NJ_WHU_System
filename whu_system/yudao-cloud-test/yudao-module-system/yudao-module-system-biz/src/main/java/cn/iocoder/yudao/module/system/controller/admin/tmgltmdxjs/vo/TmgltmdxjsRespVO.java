package cn.iocoder.yudao.module.system.controller.admin.tmgltmdxjs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 军售数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TmgltmdxjsRespVO {

    @Schema(description = "数据标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("数据标识")
    private String id;

    @Schema(description = "发布时间")
    @ExcelProperty("发布时间")
    private String publishTime;

    @Schema(description = "事件名称")
    @ExcelProperty("事件名称")
    private String title;

    @Schema(description = "关键人物")
    @ExcelProperty("关键人物")
    private String keyPeople;

    @Schema(description = "售卖部门")
    @ExcelProperty("售卖部门")
    private String saleDepartment;

    @Schema(description = "购买部门")
    @ExcelProperty("购买部门")
    private String buyDepartment;

    @Schema(description = "交易地点")
    @ExcelProperty("交易地点")
    private String dealLocation;

    @Schema(description = "交易金额")
    @ExcelProperty("交易金额")
    private String dealNum;

    @Schema(description = "武器类型及数量")
    @ExcelProperty("武器类型及数量")
    private String weaponTypeNum;

    @Schema(description = "事件影响")
    @ExcelProperty("事件影响")
    private String eventImpact;

    @Schema(description = "事件概述")
    @ExcelProperty("事件概述")
    private String content;

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