package cn.iocoder.yudao.module.system.dal.dataobject.Jzldrzytc;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 专业特长数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_zytc")
@KeySequence("jzldr_zytc_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrzytcDO{

    /**
     * 专业特长id
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
     * 专业领域
     */
    private String funcArea;
    /**
     * 专业领域描述
     */
    private String funcAreaDes;
    /**
     * 领域主张
     */
    private String funcAreaAdv;
    /**
     * 领域职位
     */
    private String profesTecPos;
    /**
     * 最新动向
     */
    private String direction;
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

}