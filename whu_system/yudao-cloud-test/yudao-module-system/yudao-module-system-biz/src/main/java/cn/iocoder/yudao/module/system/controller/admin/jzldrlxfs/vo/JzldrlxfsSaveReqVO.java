package cn.iocoder.yudao.module.system.controller.admin.jzldrlxfs.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 联系方式数据新增/修改 Request VO")
@Data
public class JzldrlxfsSaveReqVO {

    @Schema(description = "联系方式id", example = "demo")
    private String id;

    @Schema(description = "人物id", example = "demo")
    private String rwid;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "社交媒体账号", example = "demo")
    private String socialMediaAccount;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "更新时间")
    private String updateTime;

    @Schema(description = "审阅状态")
    private String reviewStatue;

    @Schema(description = "原网页")
    private String sourceNet;

}