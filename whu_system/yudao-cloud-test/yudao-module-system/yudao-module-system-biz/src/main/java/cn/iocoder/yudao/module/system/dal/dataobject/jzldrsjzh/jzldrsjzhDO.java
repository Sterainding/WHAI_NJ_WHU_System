package cn.iocoder.yudao.module.system.dal.dataobject.jzldrsjzh;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 社交账号数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_sjzh")
@KeySequence("jzldr_sjzh_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class jzldrsjzhDO {

    /**
     * 人物uid
     */
    @TableId(type = IdType.INPUT)
    private String uid;
    /**
     * 人物id
     */
    private String rwid;
    /**
     * 人物姓名
     */
    private String name;
    /**
     * 社交平台
     */
    private String platform;
    /**
     * 社交账号
     */
    private String account;
    /**
     * 发布内容
     */
    private String postContent;
    /**
     * 发布时间
     */
    private String postTime;
    /**
     * 粉丝数
     */
    private String fans;
    /**
     * 订阅数
     */
    private String subscribe;
    /**
     * 评论数
     */
    private String comment;
    /**
     * 数据来源
     */
    private String source;
    /**
     * 备注
     */
    private String 备注;
    /**
     * 审阅状态
     */
    private String reviewStatue;

    private String sourceNet;

    private String updateTime;

    private String countryRegionCode;

    private String countryRegionName;

    private String repost;

}