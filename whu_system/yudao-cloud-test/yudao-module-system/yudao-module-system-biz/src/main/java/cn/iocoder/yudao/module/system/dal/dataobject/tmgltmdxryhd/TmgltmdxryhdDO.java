package cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxryhd;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 人员活动数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_tmdxryhd")
@KeySequence("tmgl_tmdxryhd_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmgltmdxryhdDO{

    /**
     * 数据标识
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 发布时间
     */
    private String pushTime;
    /**
     * 发布单位/渠道
     */
    private String pushChannel;
    /**
     * 事件名称
     */
    private String eventTitle;
    /**
     * 参与人员
     */
    private String participant;
    /**
     * 涉及单位
     */
    private String relatedPublish;
    /**
     * 活动地点
     */
    private String eventLocation;
    /**
     * 活动时间
     */
    private String eventTime;
    /**
     * 事件影响
     */
    private String impact;
    /**
     * 相关评论
     */
    private String relatedComments;
    /**
     * 数据来源
     */
    private String eventContent;
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