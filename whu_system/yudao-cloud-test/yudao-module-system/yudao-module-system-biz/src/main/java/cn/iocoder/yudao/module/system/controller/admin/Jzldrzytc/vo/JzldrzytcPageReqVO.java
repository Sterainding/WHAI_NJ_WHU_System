package cn.iocoder.yudao.module.system.controller.admin.Jzldrzytc.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 专业特长数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrzytcPageReqVO extends PageParam {

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "专业领域")
    private String funcArea;

    @Schema(description = "领域职位")
    private String profesTecPos;

}