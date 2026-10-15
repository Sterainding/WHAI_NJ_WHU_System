package cn.iocoder.yudao.module.system.controller.admin.hwtxzcystxzc.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 红外原始图像侦察数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HwtxzcystxzcPageReqVO extends PageParam {

    @Schema(description = "国家及地区")
    private String countryRegionName;

    @Schema(description = "文件名称", example = "demo")
    private String fileName;

    @Schema(description = "类型", example = "demo")
    private String fileType;

    @Schema(description = "格式")
    private String fileFormat;

    @Schema(description = "拍摄设备", example = "demo")
    private String sensorType;

}