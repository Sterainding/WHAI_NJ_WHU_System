package cn.iocoder.yudao.module.system.controller.admin.jzldrzzzz.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 政治主张数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrzzzzPageReqVO extends PageParam {

    @Schema(description = "人物uid", example = "demo")
    private String uid;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "涉及领域")
    private String involvedField;

    @Schema(description = "政治标签")
    private String politicsTags;

}