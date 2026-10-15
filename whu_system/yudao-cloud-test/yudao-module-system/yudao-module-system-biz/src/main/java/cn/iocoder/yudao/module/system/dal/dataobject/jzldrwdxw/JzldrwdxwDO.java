package cn.iocoder.yudao.module.system.dal.dataobject.jzldrwdxw;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 污点新闻数据 DO
 *
 * @author 芋道源码
 */
@TableName("jzldr_wdxw")
@KeySequence("jzldr_wdxw_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JzldrwdxwDO{

    /**
     * 污点新闻id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 人物id
     */
    private String rwid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 新闻标题
     */
    private String relNewsHea;
    /**
     * 出现时间
     */
    private String occurrTime;
    /**
     * 内容总结
     */
    private String summarize;
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

    private String sHRAttitudesToScandal;

}