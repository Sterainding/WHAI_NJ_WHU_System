package cn.iocoder.yudao.module.system.controller.admin.jzldryjl.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 教育经历数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldryjlPageReqVO extends PageParam {

    @Schema(description = "教育经历id", example = "demo")
    private String uid;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "毕业院校")
    private String graduatedSchool;

    @Schema(description = "学历")
    private String educationLevel;

}