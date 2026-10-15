package cn.iocoder.yudao.module.system.dal.dataobject.tmgltmfwys;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 台美防务预算数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_tmfwys")
@KeySequence("tmgl_tmfwys_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmgltmfwysDO {

    /**
     * 数据标识
     */
    @TableId(type = IdType.INPUT)
    private String budgetId;
    /**
     * 预算发布方
     */
    private String budgetPulisher;
    /**
     * 预算时间
     */
    private String budgetTime;
    /**
     * 预算科目
     */
    private String budgetAccount;
    /**
     * 总预算金额
     */
    private String totalBudgetAmount;
    /**
     * 预算用途
     */
    private String budgetUsing;
    /**
     * 预算流向方
     */
    private String budgetFlowTo;
    /**
     * 发布时间
     */
    private String publishTime;
    /**
     * 内容概述
     */
    private String content;
    /**
     * 数据来源
     */
    private String source;
    /**
     * 审阅状态
     */
    private String reviewStatue;

    private String sourceNet;

    private String updateTime;

    private String countryRegionCode;

    private String countryRegionName;

}