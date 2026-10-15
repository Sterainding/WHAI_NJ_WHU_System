package cn.iocoder.yudao.module.system.dal.dataobject.tmglzkyjrybj;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 智库研究员背景数据 DO
 *
 * @author 芋道源码
 */
@TableName("tmgl_zkyjrybj")
@KeySequence("tmgl_zkyjrybj_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TmglzkyjrybjDO{

    /**
     * 人员标识
     */
    @TableId(type = IdType.INPUT)
    private String peopleId;
    /**
     * 研究报告标识
     */
    private String id;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 受教育程度
     */
    private String educationLevel;
    /**
     * 审阅状态
     */
    private String reviewStatue;

    private String updateTime;

    private String source;

    private String countryRegionCode;

    private String countryRegionName;

    private String publishTime;

}