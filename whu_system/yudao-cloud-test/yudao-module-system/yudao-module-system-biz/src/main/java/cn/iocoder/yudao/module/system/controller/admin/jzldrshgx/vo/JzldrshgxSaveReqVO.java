package cn.iocoder.yudao.module.system.controller.admin.jzldrshgx.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 社会关系数据新增/修改 Request VO")
@Data
public class JzldrshgxSaveReqVO {

    @Schema(description = "人物uid", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "社会成员名称", example = "demo")
    private String socialMemberName;

    @Schema(description = "社交活动圈子", example = "demo")
    private String socialCircleName;

    @Schema(description = "关系类型")
    private String socialRelationship;

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