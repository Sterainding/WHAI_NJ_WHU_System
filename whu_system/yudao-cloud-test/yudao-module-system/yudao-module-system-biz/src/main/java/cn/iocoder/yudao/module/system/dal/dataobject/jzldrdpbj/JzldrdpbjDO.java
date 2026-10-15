package cn.iocoder.yudao.module.system.dal.dataobject.jzldrdpbj;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 党派背景数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_dpbj")
@KeySequence("jzldr_dpbj_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrdpbjDO {

    /**
     * 党派背景id
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
     * 党派
     */
    private String politicalParty;
    /**
     * 党派政策
     */
    private String partyPolitics;
    /**
     * 入党时间
     */
    private String partyJoinDate;
    /**
     * 党内工作
     */
    private String partyJob;
    /**
     * 党派倾向
     */
    private String partySide;

    private String countryRegionCode;

    private String countryRegionName;

    private String publishTime;

    /**
     * 审阅状态
     */
    private String reviewStatue;
}