package cn.iocoder.yudao.module.system.controller.admin.tmglzkyjrybj.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 智库研究员背景数据新增/修改 Request VO")
@Data
public class TmglzkyjrybjSaveReqVO {

    @Schema(description = "人员标识", requiredMode = Schema.RequiredMode.REQUIRED)
    private String peopleId;

    @Schema(description = "研究报告标识")
    private String id;

    @Schema(description = "出生日期")
    private String birthday;

    @Schema(description = "受教育程度")
    private String educationLevel;

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

    @Schema(description = "数据来源")
    private String source;

}