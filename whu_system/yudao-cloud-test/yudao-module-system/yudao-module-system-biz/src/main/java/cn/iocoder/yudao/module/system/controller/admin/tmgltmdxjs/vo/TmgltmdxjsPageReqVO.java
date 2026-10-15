package cn.iocoder.yudao.module.system.controller.admin.tmgltmdxjs.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 军售数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmgltmdxjsPageReqVO extends PageParam {

    @Schema(description = "售卖部门")
    private String saleDepartment;

    @Schema(description = "购买部门")
    private String buyDepartment;

    @Schema(description = "交易地点")
    private String dealLocation;

    @Schema(description = "武器类型及数量")
    private String weaponTypeNum;

}