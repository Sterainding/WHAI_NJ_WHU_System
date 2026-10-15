package cn.iocoder.yudao.module.system.controller.admin.tmglzkyjbg.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 智库研究报告数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmglzkyjbgPageReqVO extends PageParam {

    @Schema(description = "发布日期")
    private String[] publishTime;

    @Schema(description = "发布作者")
    private String author;

    @Schema(description = "报告名称")
    private String reportName;

    @Schema(description = "报告关键词")
    private String keywords;

}