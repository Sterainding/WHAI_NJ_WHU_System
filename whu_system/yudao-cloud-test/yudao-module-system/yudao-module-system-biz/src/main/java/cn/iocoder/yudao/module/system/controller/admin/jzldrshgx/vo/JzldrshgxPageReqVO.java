package cn.iocoder.yudao.module.system.controller.admin.jzldrshgx.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 社会关系数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrshgxPageReqVO extends PageParam {

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "社会成员名称", example = "demo")
    private String socialMemberName;

    @Schema(description = "社交活动圈子", example = "demo")
    private String socialCircleName;

    @Schema(description = "关系类型")
    private String socialRelationship;

}