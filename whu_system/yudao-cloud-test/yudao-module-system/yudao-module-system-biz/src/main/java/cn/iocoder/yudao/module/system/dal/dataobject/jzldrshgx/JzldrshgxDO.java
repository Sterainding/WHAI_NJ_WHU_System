package cn.iocoder.yudao.module.system.dal.dataobject.jzldrshgx;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 社会关系数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_shgx")
@KeySequence("jzldr_shgx_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrshgxDO {

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
     * 社会成员名称
     */
    private String socialMemberName;
    /**
     * 社交活动圈子
     */
    private String socialCircleName;
    /**
     * 关系类型
     */
    private String socialRelationship;
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