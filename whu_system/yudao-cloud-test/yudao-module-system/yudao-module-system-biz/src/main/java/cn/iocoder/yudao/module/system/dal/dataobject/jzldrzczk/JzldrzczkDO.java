package cn.iocoder.yudao.module.system.dal.dataobject.jzldrzczk;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资产状况数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_zczk")
@KeySequence("jzldr_zczk_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrzczkDO{

    /**
     * 资产状况id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 人物id
     */
    private String rwid;
    /**
     * 人物姓名
     */
    private String name;
    /**
     * 资产类型
     */
    private String assetType;
    /**
     * 资产描述
     */
    private String totAssetsDes;
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