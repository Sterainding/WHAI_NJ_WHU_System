package cn.iocoder.yudao.module.system.controller.admin.hwtxzcmbsb.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 红外目标识别数据新增/修改 Request VO")
@Data
public class HwtxzcmbsbSaveReqVO {

    @Schema(description = "目标标识")
    private String id;

    @Schema(description = "拍摄国家及地区	")
    private String countryRegionName;

    @Schema(description = "目标纬度")
    private String longitude;

    @Schema(description = "目标经度")
    private String latitude;

    @Schema(description = "目标相对位置")
    private String relativeLocation;

    @Schema(description = "目标类型")
    private String targetType;

    @Schema(description = "目标相对大小")
    private String targetSize;

    @Schema(description = "目标型号")
    private String targetModelNumber;

    @Schema(description = "目标数量")
    private String targetNumber;

    @Schema(description = "来源网页")
    private String source;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    private String sourceNet;

    @Schema(description = "发布时间")
    private String publishTime;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

}