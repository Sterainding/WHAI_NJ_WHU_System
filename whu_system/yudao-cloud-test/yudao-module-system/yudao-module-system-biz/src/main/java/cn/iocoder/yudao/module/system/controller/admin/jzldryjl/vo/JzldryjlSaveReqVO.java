package cn.iocoder.yudao.module.system.controller.admin.jzldryjl.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 教育经历数据新增/修改 Request VO")
@Data
public class JzldryjlSaveReqVO {

    @Schema(description = "教育经历id", example = "demo")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "人物教育经历编号", example = "demo")
    private String jyid;

    @Schema(description = "毕业院校")
    private String graduatedSchool;

    @Schema(description = "学位")
    private String degree;

    @Schema(description = "学历")
    private String educationLevel;

    @Schema(description = "专业")
    private String major;

    @Schema(description = "论文")
    private String paperList;

    @Schema(description = "描述", example = "demo")
    private String description;

    @Schema(description = "数据来源")
    private String source;

    @Schema(description = "审阅状态")
    private String reviewStatue;

}