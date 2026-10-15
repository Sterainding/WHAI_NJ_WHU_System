package cn.iocoder.yudao.module.system.controller.admin.jzldrzczk.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 资产状况数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrzczkRespVO {

    @Schema(description = "资产状况id", example = "demo")
    @ExcelProperty("资产状况id")
    private String id;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String rwid;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "资产类型", example = "demo")
    @ExcelProperty("资产类型")
    private String assetType;

    @Schema(description = "资产描述")
    @ExcelProperty("资产描述")
    private String totAssetsDes;

    @Schema(description = "数据来源")
    @ExcelProperty("数据来源")
    private String source;

    @Schema(description = "审阅状态")
    @ExcelProperty("审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    @ExcelProperty("原网页")
    private String sourceNet;

    @Schema(description = "更新时间")
    @ExcelProperty("更新时间")
    private String updateTime;

    @Schema(description = "国家（地区）编码")
    @ExcelProperty("国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    @ExcelProperty("国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "发布时间")
    @ExcelProperty("发布时间")
    private String publishTime;

}