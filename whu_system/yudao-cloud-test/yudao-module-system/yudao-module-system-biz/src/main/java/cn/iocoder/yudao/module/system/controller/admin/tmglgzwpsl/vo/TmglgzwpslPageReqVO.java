package cn.iocoder.yudao.module.system.controller.admin.tmglgzwpsl.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 购置物品及数量数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmglgzwpslPageReqVO extends PageParam {

    @Schema(description = "物品名称")
    private String itemName;

}