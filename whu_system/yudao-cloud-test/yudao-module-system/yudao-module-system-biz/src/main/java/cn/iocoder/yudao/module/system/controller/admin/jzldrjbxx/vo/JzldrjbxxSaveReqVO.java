package cn.iocoder.yudao.module.system.controller.admin.jzldrjbxx.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 基本信息数据新增/修改 Request VO")
@Data
public class JzldrjbxxSaveReqVO {

    @Schema(description = "人物id", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    private String id;

    @Schema(description = "姓名", example = "demo")
    private String name;

    @Schema(description = "曾用名", example = "demo")
    private String formerName;

//    @Schema(description = "国家")
//    private String countryRegionName;

    @Schema(description = "性别")
    private String sexy;

    @Schema(description = "出生日期")
    private String birthday;

    @Schema(description = "祖籍")
    private String jg;

    @Schema(description = "年龄")
    private String age;

    @Schema(description = "军事类别")
    private String militaryBranch;

    @Schema(description = "军事等级")
    private String militaryRank;

    @Schema(description = "工作地点")
    private String jobPosition;

    @Schema(description = "工作机关")
    private String department;

    @Schema(description = "人物照片")
    private String profile;

    @Schema(description = "人物介绍")
    private String introduction;

    @Schema(description = "工作社会关系")
    private String workRelationship;

    @Schema(description = "婚姻状况", example = "demo")
    private String maritalStatus;

    @Schema(description = "民族")
    private String ethnicity;

    @Schema(description = "性格特点")
    private String bigFivePersonalityTraits;

    @Schema(description = "性格标签")
    private String personalityTags;

    @Schema(description = "任务爱好")
    private String interest;

    @Schema(description = "政治倾向")
    private String tendencyInMajorDecision;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "原网页")
    private String sourceNet;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "政策事件及影响")
    private String policiesAndImpacts;

    @Schema(description = "重要政治事件")
    private String importantPoliticalEvents;

    @Schema(description = "媒体政要民众对其言论态度")
    private String mAttitudesToRemarks;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "发布时间")
    private String publishTime;

}