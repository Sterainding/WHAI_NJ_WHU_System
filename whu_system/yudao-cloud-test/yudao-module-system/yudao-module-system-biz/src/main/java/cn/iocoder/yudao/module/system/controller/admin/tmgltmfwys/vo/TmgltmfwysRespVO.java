package cn.iocoder.yudao.module.system.controller.admin.tmgltmfwys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 台美防务预算数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TmgltmfwysRespVO {

    @Schema(description = "数据标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("数据标识")
    private String budgetId;

    @Schema(description = "预算发布方")
    @ExcelProperty("预算发布方")
    private String budgetPulisher;

    @Schema(description = "预算时间")
    @ExcelProperty("预算时间")
    private String budgetTime;

    @Schema(description = "预算科目")
    @ExcelProperty("预算科目")
    private String budgetAccount;

    @Schema(description = "总预算金额")
    @ExcelProperty("总预算金额")
    private String totalBudgetAmount;

    @Schema(description = "预算用途")
    @ExcelProperty("预算用途")
    private String budgetUsing;

    @Schema(description = "预算流向方")
    @ExcelProperty("预算流向方")
    private String budgetFlowTo;

    @Schema(description = "发布时间")
    @ExcelProperty("发布时间")
    private String publishTime;

    @Schema(description = "内容概述")
    @ExcelProperty("内容概述")
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