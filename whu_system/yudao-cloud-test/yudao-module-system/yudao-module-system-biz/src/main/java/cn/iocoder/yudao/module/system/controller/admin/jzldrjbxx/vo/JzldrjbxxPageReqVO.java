package cn.iocoder.yudao.module.system.controller.admin.jzldrjbxx.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 基本信息数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrjbxxPageReqVO extends PageParam {

    @Schema(description = "姓名", example = "demo")
    private String name;

    @Schema(description = "国家")
    private String countryRegionName;

    @Schema(description = "军事类别")
    private String militaryBranch;

    @Schema(description = "军事等级")
    private String militaryRank;

    @Schema(description = "民族")
    private String ethnicity;

}