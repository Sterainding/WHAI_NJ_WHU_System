package cn.iocoder.yudao.module.system.dal.dataobject.jzldrzzzz;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 政治主张数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_zzzz")
@KeySequence("jzldr_zzzz_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrzzzzDO {

    /**
     * 人物uid
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
     * 涉及领域
     */
    private String involvedField;
    /**
     * 政治主张
     */
    private String politicsContent;
    /**
     * 政治标签
     */
    private String politicsTags;
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

    private String attitude;
}