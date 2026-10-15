package cn.iocoder.yudao.module.system.dal.dataobject.tmgljsjlkz;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 军事交流项目和开支数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_jsjlkz")
@KeySequence("tmgl_jsjlkz_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmgljsjlkzDO  {

    /**
     * 数据标识
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 军事交流名称
     */
    private String name;
    /**
     * 交流地区
     */
    private String area;
    /**
     * 开始日期
     */
    private String startDate;
    /**
     * 结束日期
     */
    private String endDate;
    /**
     * 经费总开支
     */
    private String totalExpenditure;
    /**
     * 主导国家
     */
    private String leadingCountry;
    /**
     * 项目负责人或机构
     */
    private String militaryType;
    /**
     * 资金来源
     */
    private String fundingSource;
    /**
     * 内容概述
     */
    private String content;
    /**
     * 数据来源
     */
    private String source;
    /**
     * 军种
     */
    private String militaryBranch;
    /**
     * 审阅状态
     */
    private String reviewStatue;

    private String sourceNet;

    private String updateTime;

    private String countryRegionCode;

    private String countryRegionName;

    private String publishTime;

}