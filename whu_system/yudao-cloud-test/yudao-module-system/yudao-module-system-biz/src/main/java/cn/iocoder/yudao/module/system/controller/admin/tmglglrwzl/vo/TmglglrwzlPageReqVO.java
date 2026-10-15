package cn.iocoder.yudao.module.system.controller.admin.tmglglrwzl.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 人员资料数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmglglrwzlPageReqVO extends PageParam {

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "国家或地区")
    private String countryRegionName;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "党派")
    private String partisan;

    @Schema(description = "职务")
    private String position;

}