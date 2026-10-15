package cn.iocoder.yudao.module.system.controller.admin.tmglglgxwl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 关系网络数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TmglglgxwlRespVO {

    @Schema(description = "人物数据标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("人物数据标识")
    private String id;

    @Schema(description = "勾连人员姓名")
    @ExcelProperty("勾连人员姓名")
    private String name;

    @Schema(description = "人物简介")
    @ExcelProperty("人物简介")
    private String introduction;

    @Schema(description = "家庭关系")
    @ExcelProperty("家庭关系")
    private String familyRelations;

    @Schema(description = "关系网络")
    @ExcelProperty("关系网络")
    private String relationshipNetwork;

    @Schema(description = "对华态度")
    @ExcelProperty("对华态度")
    private String attitudeToChina;

    @Schema(description = "对华言论")
    @ExcelProperty("对华言论")
    private String speechOnChina;

    @Schema(description = "对美态度")
    @ExcelProperty("对美态度")
    private String attitudeToUs;

    @Schema(description = "对美言论")
    @ExcelProperty("对美言论")
    private String speechOnUs;

    @Schema(description = "背后利益集团介绍")
    @ExcelProperty("背后利益集团介绍")
    private String interestGroups;

    @Schema(description = "直接上级")
    @ExcelProperty("直接上级")
    private String directSuperior;

    @Schema(description = "社交媒体账户")
    @ExcelProperty("社交媒体账户")
    private String socialAccount;

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