package cn.iocoder.yudao.module.system.controller.admin.tmgljsjlkz.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 军事交流项目和开支数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmgljsjlkzPageReqVO extends PageParam {

    @Schema(description = "军事交流名称")
    private String name;

    @Schema(description = "交流地区")
    private String area;

    @Schema(description = "主导国家")
    private String leadingCountry;

    @Schema(description = "军种")
    private String militaryBranch;

}