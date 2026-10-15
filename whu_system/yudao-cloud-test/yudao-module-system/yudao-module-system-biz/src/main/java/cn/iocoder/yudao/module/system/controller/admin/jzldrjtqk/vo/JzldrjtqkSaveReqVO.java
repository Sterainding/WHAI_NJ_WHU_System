package cn.iocoder.yudao.module.system.controller.admin.jzldrjtqk.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 家庭情况数据新增/修改 Request VO")
@Data
public class JzldrjtqkSaveReqVO {

    @Schema(description = "家庭情况id", example = "demo")
    private String uid;

    @Schema(description = "人物id", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    @NotEmpty(message = "人物id不能为空")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "家庭主要成员名称", example = "demo")
    private String familyMemberName;

    @Schema(description = "关系类型")
    private String familyRelationship;

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