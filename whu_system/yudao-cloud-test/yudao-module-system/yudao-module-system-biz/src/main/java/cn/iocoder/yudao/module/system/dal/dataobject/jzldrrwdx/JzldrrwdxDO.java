package cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwdx;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 人物动向数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_rwdx")
@KeySequence("jzldr_rwdx_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrrwdxDO {

    /**
     * 人物id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 人物动向id
     */
    private String uid;
    /**
     * 人物姓名
     */
    private String name;
    /**
     * 动向标题
     */
    private String actionTopic;
    /**
     * 动向时间
     */
    private String actionTime;
    /**
     * 动向地点
     */
    private String actionPlace;
    /**
     * 合作成员名单
     */
    private String companyMembersList;
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

    private String updateTime;

    private String countryRegionCode;

    private String countryRegionName;

    private String publishTime;

    private String reviewStatue;

    private String sourceNet;
}