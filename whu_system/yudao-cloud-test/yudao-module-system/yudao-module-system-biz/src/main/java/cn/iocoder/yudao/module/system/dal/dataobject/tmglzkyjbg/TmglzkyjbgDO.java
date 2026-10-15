package cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjbg;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 智库研究报告数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_zkyjbg")
@KeySequence("tmgl_zkyjbg_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmglzkyjbgDO{

    /**
     * 数据标识
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 发布日期
     */
    private String publishTime;
    /**
     * 发布机构
     */
    private String publishAgency;
    /**
     * 发布作者
     */
    private String author;
    /**
     * 作者背景
     */
    private String authorBackground;
    /**
     * 涉及问题
     */
    private String about;
    /**
     * 报告名称
     */
    private String reportName;
    /**
     * 报告影响评估
     */
    private String influence;
    /**
     * 报告内容
     */
    private String content;
    /**
     * 报告关键词
     */
    private String keywords;
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