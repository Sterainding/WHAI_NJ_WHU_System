package cn.iocoder.yudao.module.system.controller.admin.jzldrzzzz.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 政治主张数据新增/修改 Request VO")
@Data
public class JzldrzzzzSaveReqVO {

    @Schema(description = "人物uid", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "涉及领域")
    private String involvedField;

    @Schema(description = "政治主张")
    private String politicsContent;

    @Schema(description = "政治标签")
    private String politicsTags;

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

    @Schema(description = "对华态度")
    private String attitude;

    @Schema(description = "原网页")
    private String sourceNet;
}