package cn.iocoder.yudao.module.system.controller.admin.jzldrjbxx.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 基本信息数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrjbxxRespVO {

    @Schema(description = "人物id", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    @ExcelProperty("人物id")
    private String id;

    @Schema(description = "姓名", example = "demo")
    @ExcelProperty("姓名")
    private String name;

    @Schema(description = "曾用名", example = "demo")
    @ExcelProperty("曾用名")
    private String formerName;

//    @Schema(description = "国家")
//    @ExcelProperty("国家")
//    private String country;

    @Schema(description = "性别")
    @ExcelProperty("性别")
    private String sexy;

    @Schema(description = "出生日期")
    @ExcelProperty("出生日期")
    private String birthday;

    @Schema(description = "祖籍")
    @ExcelProperty("祖籍")
    private String jg;

    @Schema(description = "年龄")
    @ExcelProperty("年龄")
    private String age;

    @Schema(description = "军事类别")
    @ExcelProperty("军事类别")
    private String militaryBranch;

    @Schema(description = "军事等级")
    @ExcelProperty("军事等级")
    private String militaryRank;

    @Schema(description = "工作地点")
    @ExcelProperty("工作地点")
    private String jobPosition;

    @Schema(description = "工作机关")
    @ExcelProperty("工作机关")
    private String department;

    @Schema(description = "人物照片")
    @ExcelProperty("人物照片")
    private String profile;

    @Schema(description = "人物介绍")
    @ExcelProperty("人物介绍")
    private String introduction;

    @Schema(description = "工作社会关系")
    @ExcelProperty("工作社会关系")
    private String workRelationship;

    @Schema(description = "婚姻状况", example = "demo")
    @ExcelProperty("婚姻状况")
    private String maritalStatus;

    @Schema(description = "民族")
    @ExcelProperty("民族")
    private String ethnicity;

    @Schema(description = "性格特点")
    @ExcelProperty("性格特点")
    private String bigFivePersonalityTraits;

    @Schema(description = "性格标签")
    @ExcelProperty("性格标签")
    private String personalityTags;

    @Schema(description = "任务爱好")
    @ExcelProperty("任务爱好")
    private String interest;

    @Schema(description = "政治倾向")
    @ExcelProperty("政治倾向")
    private String tendencyInMajorDecision;


    @Schema(description = "更新时间")
    @ExcelProperty("更新时间")
    private String updateTime;

    @Schema(description = "政策事件及影响")
    @ExcelProperty("政策事件及影响")
    private String policiesAndImpacts;

    @Schema(description = "重要政治事件")
    @ExcelProperty("重要政治事件")
    private String importantPoliticalEvents;

    @Schema(description = "媒体政要民众对其言论态度")
    @ExcelProperty("媒体政要民众对其言论态度")
    private String mAttitudesToRemarks;

    @Schema(description = "国家（地区）名称")
    @ExcelProperty("国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "发布时间")
    @ExcelProperty("发布时间")
    private String publishTime;


    @Schema(description = "审阅状态")
    @ExcelProperty("审阅状态")
    private String reviewStatue;

    @Schema(description = "数据来源")
    @ExcelProperty("数据来源")
    private String source;

    @Schema(description = "原网页")
    @ExcelProperty("原网页")
    private String sourceNet;

}