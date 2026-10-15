package cn.iocoder.yudao.module.system.controller.admin.jzldrrzjl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 任职经历数据新增/修改 Request VO")
@Data
public class JzldrrzjlSaveReqVO {

    @Schema(description = "任职经历id", example = "demo")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "任职id", example = "demo")
    private String rzid;

    @Schema(description = "参加工作时间")
    private String employmentTime;

    @Schema(description = "工作状态（现职/退休）")
    private String employmentState;

    @Schema(description = "机构名称", example = "demo")
    private String institutionName;

    @Schema(description = "职务")
    private String position;

    @Schema(description = "任职时间")
    private String jobTime;

    @Schema(description = "工作地点")
    private String workLocation;

    @Schema(description = "描述", example = "demo")
    private String description;

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