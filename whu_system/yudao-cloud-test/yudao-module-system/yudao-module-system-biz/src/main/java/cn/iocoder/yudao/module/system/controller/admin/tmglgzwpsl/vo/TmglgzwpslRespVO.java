package cn.iocoder.yudao.module.system.controller.admin.tmglgzwpsl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 购置物品及数量数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TmglgzwpslRespVO {

    @Schema(description = "数据标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("数据标识")
    private String itemId;

    @Schema(description = "交易标识")
    @ExcelProperty("交易标识")
    private String budgetId;

    @Schema(description = "物品名称")
    @ExcelProperty("物品名称")
    private String itemName;

    @Schema(description = "物品数量")
    @ExcelProperty("物品数量")
    private String quantity;

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