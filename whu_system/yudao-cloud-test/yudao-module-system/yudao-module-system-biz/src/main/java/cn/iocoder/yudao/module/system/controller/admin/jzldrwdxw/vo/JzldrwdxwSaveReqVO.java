package cn.iocoder.yudao.module.system.controller.admin.jzldrwdxw.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 污点新闻数据新增/修改 Request VO")
@Data
public class JzldrwdxwSaveReqVO {

    @Schema(description = "污点新闻id", example = "demo")
    private String id;

    @Schema(description = "人物id", example = "demo")
    private String rwid;

    @Schema(description = "姓名", example = "demo")
    private String name;

    @Schema(description = "新闻标题")
    private String relNewsHea;

    @Schema(description = "出现时间")
    private String occurrTime;

    @Schema(description = "内容总结")
    private String summarize;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    private String sourceNet;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "发布时间")
    private String publishTime;

    @Schema(description = "美参众两院对丑闻的言论态度")
    private String sHRAttitudesToScandal;
}