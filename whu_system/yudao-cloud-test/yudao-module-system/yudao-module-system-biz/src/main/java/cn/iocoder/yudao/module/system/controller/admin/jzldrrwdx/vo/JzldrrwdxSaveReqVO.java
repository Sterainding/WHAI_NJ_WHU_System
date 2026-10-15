package cn.iocoder.yudao.module.system.controller.admin.jzldrrwdx.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 人物动向数据新增/修改 Request VO")
@Data
public class JzldrrwdxSaveReqVO {

    @Schema(description = "人物id", requiredMode = Schema.RequiredMode.REQUIRED, example = "demo")
    private String id;

    @Schema(description = "人物动向id", example = "demo")
    private String uid;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "动向标题")
    private String actionTopic;

    @Schema(description = "动向时间")
    private String actionTime;

    @Schema(description = "动向地点")
    private String actionPlace;

    @Schema(description = "合作成员名单")
    private String companyMembersList;

    @Schema(description = "描述", example = "demo")
    private String description;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "发布时间")
    private String publishTime;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    private String sourceNet;

}