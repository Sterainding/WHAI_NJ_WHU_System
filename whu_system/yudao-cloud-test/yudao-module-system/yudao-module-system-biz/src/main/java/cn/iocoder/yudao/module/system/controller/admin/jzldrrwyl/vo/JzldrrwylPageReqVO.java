package cn.iocoder.yudao.module.system.controller.admin.jzldrrwyl.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 人物言论分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrrwylPageReqVO extends PageParam {

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "言论内容")
    private String issueContent;

    @Schema(description = "言论发布时间")
    private String[] issuePublishTime;

}