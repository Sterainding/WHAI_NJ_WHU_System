package cn.iocoder.yudao.module.system.dal.dataobject.jzldrlxfs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
/**
 * 联系方式数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_lxfs")
@KeySequence("jzldr_lxfs_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrlxfsDO{

    /**
     * 联系方式id
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
     * 社交媒体账号
     */
    private String socialMediaAccount;
    /**
     * 邮箱
     */
    private String email;
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

}