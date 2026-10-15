package cn.iocoder.yudao.module.system.controller.admin.mbsb.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 红外目标识别数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MbsbRespVO {

    @Schema(description = "目标标识")
    @ExcelProperty("目标标识")
    private String id;

    @Schema(description = "拍摄国家及地区	")
    @ExcelProperty("拍摄国家及地区	")
    private String country;

    @Schema(description = "目标纬度")
    @ExcelProperty("目标纬度")
    private String longitude;

    @Schema(description = "目标经度")
    @ExcelProperty("目标经度")
    private String latitude;

    @Schema(description = "目标相对位置")
    @ExcelProperty("目标相对位置")
    private String relativeLocation;

    @Schema(description = "目标类型")
    @ExcelProperty("目标类型")
    private String targetType;

    @Schema(description = "目标相对大小")
    @ExcelProperty("目标相对大小")
    private String targetSize;

    @Schema(description = "目标型号")
    @ExcelProperty("目标型号")
    private String targetModelNumber;

    @Schema(description = "目标数量")
    @ExcelProperty("目标数量")
    private String targetNumber;

    @Schema(description = "来源网页")
    @ExcelProperty("来源网页")
    private String source;

}