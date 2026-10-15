package cn.iocoder.yudao.module.system.controller.admin.tmgljsjlkz.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 军事交流项目和开支数据新增/修改 Request VO")
@Data
public class TmgljsjlkzSaveReqVO {

    @Schema(description = "数据标识", requiredMode = Schema.RequiredMode.REQUIRED)
    private String id;

    @Schema(description = "军事交流名称")
    private String name;

    @Schema(description = "交流地区")
    private String area;

    @Schema(description = "开始日期")
    private String startDate;

    @Schema(description = "结束日期")
    private String endDate;

    @Schema(description = "经费总开支")
    private String totalExpenditure;

    @Schema(description = "主导国家")
    private String leadingCountry;

    @Schema(description = "项目负责人或机构")
    private String militaryType;

    @Schema(description = "资金来源")
    private String fundingSource;

    @Schema(description = "内容概述")
    private String content;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "军种")
    private String militaryBranch;

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