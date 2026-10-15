package cn.iocoder.yudao.module.system.controller.admin.jzldrsjzh.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 社交账号数据新增/修改 Request VO")
@Data
public class jzldrsjzhSaveReqVO {

    @Schema(description = "人物uid", example = "demo")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    private String rwid;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "社交平台")
    private String platform;

    @Schema(description = "社交账号", example = "demo")
    private String account;

    @Schema(description = "发布内容")
    private String postContent;

    @Schema(description = "发布时间")
    private String postTime;

    @Schema(description = "粉丝数")
    private String fans;

    @Schema(description = "订阅数")
    private String subscribe;

    @Schema(description = "评论数")
    private String comment;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "备注")
    private String 备注;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "转发量")
    private String repost;

    @Schema(description = "原网页")
    private String sourceNet;

}