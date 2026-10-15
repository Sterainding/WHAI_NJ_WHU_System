package cn.iocoder.yudao.module.system.dal.dataobject.tmglglgxwl;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 关系网络数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_glgxwl")
@KeySequence("tmgl_glgxwl_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmglglgxwlDO{

    /**
     * 人物数据标识
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 勾连人员姓名
     */
    private String name;
    /**
     * 人物简介
     */
    private String introduction;
    /**
     * 家庭关系
     */
    private String familyRelations;
    /**
     * 关系网络
     */
    private String relationshipNetwork;
    /**
     * 对华态度
     */
    private String attitudeToChina;
    /**
     * 对华言论
     */
    private String speechOnChina;
    /**
     * 对美态度
     */
    private String attitudeToUs;
    /**
     * 对美言论
     */
    private String speechOnUs;
    /**
     * 背后利益集团介绍
     */
    private String interestGroups;
    /**
     * 直接上级
     */
    private String directSuperior;
    /**
     * 社交媒体账户
     */
    private String socialAccount;
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

    private String publishTime;

}