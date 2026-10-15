package cn.iocoder.yudao.module.system.controller.admin.jzldrrzjl.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 任职经历数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrrzjlPageReqVO extends PageParam {

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "机构名称", example = "demo")
    private String institutionName;

    @Schema(description = "工作地点")
    private String workLocation;

}