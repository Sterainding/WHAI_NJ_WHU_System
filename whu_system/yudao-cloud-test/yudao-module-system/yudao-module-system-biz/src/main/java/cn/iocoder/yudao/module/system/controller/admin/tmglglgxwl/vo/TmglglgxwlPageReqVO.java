package cn.iocoder.yudao.module.system.controller.admin.tmglglgxwl.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 关系网络数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmglglgxwlPageReqVO extends PageParam {

    @Schema(description = "勾连人员姓名")
    private String name;

    @Schema(description = "直接上级")
    private String directSuperior;

}