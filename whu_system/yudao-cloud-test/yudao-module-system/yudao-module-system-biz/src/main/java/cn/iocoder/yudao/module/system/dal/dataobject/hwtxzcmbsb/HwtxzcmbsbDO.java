package cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcmbsb;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.dynamic.datasource.annotation.DS;
/**
 * 红外目标识别数据 DO
 *
 * @author 芋道源码
 */
@TableName("hwtxzc_mbsb")
@KeySequence("hwtxzc_mbsb_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor

@DS("whu_data")
public class HwtxzcmbsbDO {
    /**
     * 目标标识
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 拍摄国家及地区	
     */
    private String countryRegionName;
    /**
     * 目标纬度
     */
    private String longitude;
    /**
     * 目标经度
     */
    private String latitude;
    /**
     * 目标相对位置
     */
    private String relativeLocation;
    /**
     * 目标类型
     */
    private String targetType;
    /**
     * 目标相对大小
     */
    private String targetSize;
    /**
     * 目标型号
     */
    private String targetModelNumber;
    /**
     * 目标数量
     */
    private String targetNumber;
    /**
     * 来源网页
     */
    private String updateTime;

    private String source;
    /**
     * 审阅状态
     */
    private String reviewStatue;

    private String sourceNet;

    private String publishTime;

    private String countryRegionCode;
}