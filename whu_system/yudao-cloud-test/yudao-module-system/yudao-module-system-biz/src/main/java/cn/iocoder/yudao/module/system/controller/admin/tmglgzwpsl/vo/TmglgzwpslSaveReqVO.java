package cn.iocoder.yudao.module.system.controller.admin.tmglgzwpsl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 购置物品及数量数据新增/修改 Request VO")
@Data
public class TmglgzwpslSaveReqVO {

    @Schema(description = "数据标识", requiredMode = Schema.RequiredMode.REQUIRED)
    private String itemId;

    @Schema(description = "交易标识")
    private String budgetId;

    @Schema(description = "物品名称")
    private String itemName;

    @Schema(description = "物品数量")
    private String quantity;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "发布时间")
    private String publishTime;

    @Schema(description = "原网页")
    private String sourceNet;

}