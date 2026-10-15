package cn.iocoder.yudao.module.system.controller.admin.jzldrzczk.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 资产状况数据新增/修改 Request VO")
@Data
public class JzldrzczkSaveReqVO {

    @Schema(description = "资产状况id", example = "demo")
    private String id;

    @Schema(description = "人物id", example = "demo")
    private String rwid;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "资产类型", example = "demo")
    private String assetType;

    @Schema(description = "资产描述")
    private String totAssetsDes;

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