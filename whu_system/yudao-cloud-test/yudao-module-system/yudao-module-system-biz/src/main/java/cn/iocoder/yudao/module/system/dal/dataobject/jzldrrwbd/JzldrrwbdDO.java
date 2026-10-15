package cn.iocoder.yudao.module.system.dal.dataobject.jzldrrwbd;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.dynamic.datasource.annotation.DS;
@DS("whu_data")
@InterceptorIgnore(tenantLine="true")
/**
 * 人物报道数据 DO
 *
 * @author 芋道源码
 */

@TableName("jzldr_rwbd")
@KeySequence("jzldr_rwbd_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrrwbdDO{

    /**
     * 人物报道id
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
     * 新闻内容
     */
    private String newsContent;
    /**
     * 新闻标题
     */
    private String newsTitle;
    /**
     * 新闻发布时间
     */
    private String newsPublishTime;
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