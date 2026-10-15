package cn.iocoder.yudao.module.system.dal.dataobject.jzldrrzjl;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 任职经历数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_rzjl")
@KeySequence("jzldr_rzjl_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrrzjlDO{

    /**
     * 任职经历id
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
     * 任职id
     */
    private String rzid;
    /**
     * 参加工作时间
     */
    private String employmentTime;
    /**
     * 工作状态（现职/退休）
     */
    private String employmentState;
    /**
     * 机构名称
     */
    private String institutionName;
    /**
     * 职务
     */
    private String position;
    /**
     * 任职时间
     */
    private String jobTime;
    /**
     * 工作地点
     */
    private String workLocation;
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

    private String updateTime;

    private String countryRegionCode;

    private String countryRegionName;

    private String publishTime;

}