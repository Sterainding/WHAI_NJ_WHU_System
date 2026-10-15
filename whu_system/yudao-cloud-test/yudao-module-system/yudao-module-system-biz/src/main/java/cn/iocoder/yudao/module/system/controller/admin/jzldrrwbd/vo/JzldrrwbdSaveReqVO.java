package cn.iocoder.yudao.module.system.controller.admin.jzldrrwbd.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 人物报道数据新增/修改 Request VO")
@Data
public class JzldrrwbdSaveReqVO {

    @Schema(description = "人物报道id", example = "demo")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "新闻内容")
    private String newsContent;

    @Schema(description = "新闻标题")
    private String newsTitle;

    @Schema(description = "新闻发布时间")
    private String newsPublishTime;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    private String sourceNet;

}