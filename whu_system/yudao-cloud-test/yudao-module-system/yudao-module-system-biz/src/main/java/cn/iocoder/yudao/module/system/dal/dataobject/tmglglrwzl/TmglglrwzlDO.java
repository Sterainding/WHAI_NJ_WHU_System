package cn.iocoder.yudao.module.system.dal.dataobject.tmglglrwzl;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 人员资料数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_glrwzl")
@KeySequence("tmgl_glrwzl_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmglglrwzlDO {

    /**
     * 人物数据标识
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 国家或地区
     */
    private String countryRegionName;
    /**
     * 曾用名
     */
    private String formerName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 年龄
     */
    private String age;
    /**
     * 籍贯
     */
    private String birthplace;
    /**
     * 党派
     */
    private String partisan;
    /**
     * 所在部门
     */
    private String department;
    /**
     * 职务
     */
    private String position;
    /**
     * 军衔
     */
    private String militaryRank;
    /**
     * 所属军兵种
     */
    private String militaryBranch;
    /**
     * 任职时间
     */
    private String workingTime;
    /**
     * 头像
     */
    private String profile;
    /**
     * 受教育程度
     */
    private String educationLevel;
    /**
     * 教育经历
     */
    private String educationExperience;
    /**
     * 性格特点
     */
    private String characterTraits;
    /**
     * 兴趣爱好
     */
    private String hobby;
    /**
     * 婚姻状况
     */
    private String maritalStatus;
    /**
     * 重大问题决策倾向
     */
    private String tendencyInMajorDecision;
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

    private String publishTime;

}