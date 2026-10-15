package cn.iocoder.yudao.module.system.controller.admin.tmgltmfwys.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 台美防务预算数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmgltmfwysPageReqVO extends PageParam {

    @Schema(description = "预算发布方")
    private String budgetPulisher;

    @Schema(description = "预算流向方")
    private String budgetFlowTo;

    @Schema(description = "发布时间")
    private String publishTime;

}