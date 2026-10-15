package cn.iocoder.yudao.module.system.controller.admin.jzldrwdxw.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 污点新闻数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JzldrwdxwPageReqVO extends PageParam {

    @Schema(description = "姓名", example = "demo")
    private String name;

    @Schema(description = "新闻标题")
    private String relNewsHea;

    @Schema(description = "出现时间")
    private String occurrTime;

    @Schema(description = "内容总结")
    private String summarize;

}