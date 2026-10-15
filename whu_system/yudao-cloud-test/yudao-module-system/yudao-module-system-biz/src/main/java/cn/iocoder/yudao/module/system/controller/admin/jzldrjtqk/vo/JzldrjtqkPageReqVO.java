package cn.iocoder.yudao.module.system.controller.admin.jzldrjtqk.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 家庭情况数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrjtqkPageReqVO extends PageParam {

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "家庭主要成员名称", example = "demo")
    private String familyMemberName;

    @Schema(description = "关系类型")
    private String familyRelationship;

}