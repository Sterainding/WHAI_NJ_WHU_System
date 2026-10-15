package cn.iocoder.yudao.module.system.controller.admin.tmglzkyjrybj.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 智库研究员背景数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TmglzkyjrybjPageReqVO extends PageParam {

    @Schema(description = "受教育程度")
    private String educationLevel;

}