package cn.iocoder.yudao.module.system.dal.dataobject.jzldrjtqk;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 家庭情况数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_jtqk")
@KeySequence("jzldr_jtqk_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrjtqkDO {

    /**
     * 家庭情况id
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
     * 家庭主要成员名称
     */
    private String familyMemberName;
    /**
     * 关系类型
     */
    private String familyRelationship;
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