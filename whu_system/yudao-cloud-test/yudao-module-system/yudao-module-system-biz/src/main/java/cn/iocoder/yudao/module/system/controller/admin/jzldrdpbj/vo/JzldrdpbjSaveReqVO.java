package cn.iocoder.yudao.module.system.controller.admin.jzldrdpbj.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 党派背景数据新增/修改 Request VO")
@Data
public class JzldrdpbjSaveReqVO {

    @Schema(description = "党派背景id", example = "demo")
    private String uid;

    @Schema(description = "人物id", example = "demo")
    private String id;

    @Schema(description = "人物姓名", example = "demo")
    private String name;

    @Schema(description = "党派")
    private String politicalParty;

    @Schema(description = "党派政策")
    private String partyPolitics;

    @Schema(description = "入党时间")
    private String partyJoinDate;

    @Schema(description = "党内工作")
    private String partyJob;

    @Schema(description = "党派倾向")
    private String partySide;

    @Schema(description = "国家（地区）编码")
    private String countryRegionCode;

    @Schema(description = "国家（地区）名称")
    private String countryRegionName;

    @Schema(description = "发布时间")
    private String publishTime;

    @Schema(description = "审阅状态")
    private String reviewStatue;

}