package cn.iocoder.yudao.module.system.controller.admin.jzldrrwyl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 人物言论新增/修改 Request VO")
@Data
public class JzldrrwylSaveReqVO {

    @Schema(description = "人物言论id", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "言论内容")
    private String issueContent;

    @Schema(description = "言论情况")
    private String issueSituation;

    @Schema(description = "言论发布时间")
    private String issuePublishTime;

    @Schema(description = "发布类型", example = "demo")
    private String publishType;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "审阅状态")
    private String reviewStatue;

}