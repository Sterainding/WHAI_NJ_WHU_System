package cn.iocoder.yudao.module.system.dal.dataobject.tmgltmdxjs;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 军售数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_tmdxjs")
@KeySequence("tmgl_tmdxjs_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmgltmdxjsDO{

    /**
     * 数据标识
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 发布时间
     */
    private String publishTime;
    /**
     * 事件名称
     */
    private String title;
    /**
     * 关键人物
     */
    private String keyPeople;
    /**
     * 售卖部门
     */
    private String saleDepartment;
    /**
     * 购买部门
     */
    private String buyDepartment;
    /**
     * 交易地点
     */
    private String dealLocation;
    /**
     * 交易金额
     */
    private String dealNum;
    /**
     * 武器类型及数量
     */
    private String weaponTypeNum;
    /**
     * 事件影响
     */
    private String eventImpact;
    /**
     * 事件概述
     */
    private String content;
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