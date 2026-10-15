package cn.iocoder.yudao.module.system.dal.dataobject.tmglgzwpsl;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 购置物品及数量数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_gzwpsl")
@KeySequence("tmgl_gzwpsl_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmglgzwpslDO {

    /**
     * 数据标识
     */
    @TableId(type = IdType.INPUT)
    private String itemId;
    /**
     * 交易标识
     */
    private String budgetId;
    /**
     * 物品名称
     */
    private String itemName;
    /**
     * 物品数量
     */
    private String quantity;
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