package cn.iocoder.yudao.module.system.controller.admin.tmglglrwzl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 人员资料数据新增/修改 Request VO")
@Data
public class TmglglrwzlSaveReqVO {

    @Schema(description = "人物数据标识", requiredMode = Schema.RequiredMode.REQUIRED)
    private String id;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "国家或地区")
    private String countryRegionName;

    @Schema(description = "曾用名")
    private String formerName;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "出生日期")
    private String birthday;

    @Schema(description = "年龄")
    private String age;

    @Schema(description = "籍贯")
    private String birthplace;

    @Schema(description = "党派")
    private String partisan;

    @Schema(description = "所在部门")
    private String department;

    @Schema(description = "职务")
    private String position;

    @Schema(description = "军衔")
    private String militaryRank;

    @Schema(description = "所属军兵种")
    private String militaryBranch;

    @Schema(description = "任职时间")
    private String workingTime;

    @Schema(description = "头像")
    private String profile;

    @Schema(description = "受教育程度")
    private String educationLevel;

    @Schema(description = "教育经历")
    private String educationExperience;

    @Schema(description = "性格特点")
    private String characterTraits;

    @Schema(description = "兴趣爱好")
    private String hobby;

    @Schema(description = "婚姻状况", example = "demo")
    private String maritalStatus;

    @Schema(description = "重大问题决策倾向")
    private String tendencyInMajorDecision;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "发布时间")
    private String publishTime;

    @Schema(description = "原网页")
    private String sourceNet;

}