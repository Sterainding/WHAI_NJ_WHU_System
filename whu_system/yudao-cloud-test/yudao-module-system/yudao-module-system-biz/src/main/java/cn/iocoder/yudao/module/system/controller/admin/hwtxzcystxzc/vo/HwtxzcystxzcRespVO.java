package cn.iocoder.yudao.module.system.controller.admin.hwtxzcystxzc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 红外原始图像侦察数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class HwtxzcystxzcRespVO {

    @Schema(description = "红外数据标识", example = "demo")
    @ExcelProperty("红外数据标识")
    private String id;

    @Schema(description = "国家及地区")
    @ExcelProperty("国家及地区")
    private String countryRegionName;

    @Schema(description = "影像大小")
    @ExcelProperty("影像大小")
    private String imageSize;

    @Schema(description = "拍摄日期")
    @ExcelProperty("拍摄日期")
    private String dayKey;

    @Schema(description = "文件名称", example = "demo")
    @ExcelProperty("文件名称")
    private String fileName;

    @Schema(description = "分辨率")
    @ExcelProperty("分辨率")
    private String resolution;

    @Schema(description = "类型", example = "demo")
    @ExcelProperty("类型")
    private String fileType;

    @Schema(description = "格式")
    @ExcelProperty("格式")
    private String fileFormat;

    @Schema(description = "背景场景")
    @ExcelProperty("背景场景")
    private String background;

    @Schema(description = "光照条件")
    @ExcelProperty("光照条件")
    private String lightCondition;

    @Schema(description = "拍摄设备", example = "demo")
    @ExcelProperty("拍摄设备")
    private String sensorType;

    @Schema(description = "视角")
    @ExcelProperty("视角")
    private String perspective;

    @Schema(description = "来源类别")
    @ExcelProperty("来源类别")
    private String dataSource;

    @Schema(description = "来源网页")
    @ExcelProperty("来源网页")
    private String source;

    @Schema(description = "来源时长")
    @ExcelProperty("来源时长")
    private String videoLength;

    @Schema(description = "视频帧率")
    @ExcelProperty("视频帧率")
    private String videoFps;

    @Schema(description = "视频中目标出现时段")
    @ExcelProperty("视频中目标出现时段")
    private String targetAppearTime;

    @Schema(description = "本地存储路径")
    @ExcelProperty("本地存储路径")
    private String storageLocation;

    @Schema(description = "审阅状态")
    @ExcelProperty("审阅状态")
    private String reviewStatue;

    @Schema(description = "更新时间")
    @ExcelProperty("更新时间")
    private String updateTime;

    @Schema(description = "原网页")
    @ExcelProperty("原网页")
    private String sourceNet;

}