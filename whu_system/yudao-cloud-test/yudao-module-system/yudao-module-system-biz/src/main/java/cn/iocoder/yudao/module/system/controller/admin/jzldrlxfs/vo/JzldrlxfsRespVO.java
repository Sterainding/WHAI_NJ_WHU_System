package cn.iocoder.yudao.module.system.controller.admin.jzldrlxfs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 联系方式数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class JzldrlxfsRespVO {

    @Schema(description = "联系方式id", example = "demo")
    @ExcelProperty("联系方式id")
    private String id;

    @Schema(description = "人物id", example = "demo")
    @ExcelProperty("人物id")
    private String rwid;

    @Schema(description = "人物姓名", example = "demo")
    @ExcelProperty("人物姓名")
    private String name;

    @Schema(description = "社交媒体账号", example = "demo")
    @ExcelProperty("社交媒体账号")
    private String socialMediaAccount;

    @Schema(description = "邮箱")
    @ExcelProperty("邮箱")
    private String email;

    @Schema(description = "数据来源")
    @ExcelProperty("数据来源")
    private String source;

    @Schema(description = "更新时间")
    @ExcelProperty("更新时间")
    private String updateTime;

    @Schema(description = "审阅状态")
    @ExcelProperty("审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    @ExcelProperty("原网页")
    private String sourceNet;

}