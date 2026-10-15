package cn.iocoder.yudao.module.system.dal.dataobject.jzldryjl;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 教育经历数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_jyjl")
@KeySequence("jzldr_jyjl_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldryjlDO {

    /**
     * 教育经历id
     */
    @TableId(type = IdType.INPUT)
    private String uid;
    /**
     * 人物id
     */
    private String id;
    /**
     * 人物姓名
     */
    private String name;
    /**
     * 人物教育经历编号
     */
    private String jyid;
    /**
     * 毕业院校
     */
    private String graduatedSchool;
    /**
     * 学位
     */
    private String degree;
    /**
     * 学历
     */
    private String educationLevel;
    /**
     * 专业
     */
    private String major;
    /**
     * 论文
     */
    private String paperList;
    /**
     * 描述
     */
    private String description;
    /**
     * 数据来源
     */
    private String source;
    /**
     * 审阅状态
     */
    private String reviewStatue;

    private String sourceNet;

}