package cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwyl;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 人物言论 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_rwyl")
@KeySequence("jzldr_rwyl_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrrwylDO{

    /**
     * 人物言论id
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
     * 言论内容
     */
    private String issueContent;
    /**
     * 言论情况
     */
    private String issueSituation;
    /**
     * 言论发布时间
     */
    private String issuePublishTime;
    /**
     * 发布类型
     */
    private String publishType;
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