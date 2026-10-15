package cn.iocoder.yudao.module.system.controller.admin.jzldrdpbj.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 党派背景数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrdpbjPageReqVO extends PageParam {

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "党派")
    private String politicalParty;

    @Schema(description = "党内工作")
    private String partyJob;

}