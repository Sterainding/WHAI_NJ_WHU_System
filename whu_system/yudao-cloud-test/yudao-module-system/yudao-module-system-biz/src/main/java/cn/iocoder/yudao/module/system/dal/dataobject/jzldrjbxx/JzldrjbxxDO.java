package cn.iocoder.yudao.module.system.dal.dataobject.jzldrjbxx;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基本信息数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_jbxx")
@KeySequence("jzldr_jbxx_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrjbxxDO{

    /**
     * 人物id	
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 曾用名
     */
    private String formerName;
    /**
     * 国家
     */
//    private String country;
    /**
     * 性别
     */
    private String sexy;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 祖籍
     */
    private String jg;
    /**
     * 年龄
     */
    private String age;
    /**
     * 军事类别
     */
    private String militaryBranch;
    /**
     * 军事等级
     */
    private String militaryRank;
    /**
     * 工作地点
     */
    private String jobPosition;
    /**
     * 工作机关
     */
    private String department;
    /**
     * 人物照片
     */
    private String profile;
    /**
     * 人物介绍
     */
    private String introduction;
    /**
     * 工作社会关系
     */
    private String workRelationship;
    /**
     * 婚姻状况
     */
    private String maritalStatus;
    /**
     * 民族
     */
    private String ethnicity;
    /**
     * 性格特点
     */
    private String bigFivePersonalityTraits;
    /**
     * 性格标签
     */
    private String personalityTags;
    /**
     * 任务爱好
     */
    private String interest;
    /**
     * 政治倾向
     */
    private String tendencyInMajorDecision;
    /**
     * 审阅状态
     */
    private String reviewStatue;
    /**
     * 数据来源
     */
    private String source;

    private String sourceNet;

    private String updateTime;

    private String policiesAndImpacts;

    private String importantPoliticalEvents;

    private String mAttitudesToRemarks;

    private String countryRegionName;

    private String publishTime;

}