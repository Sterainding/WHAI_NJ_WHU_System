package cn.iocoder.yudao.module.system.dal.dataobject.hwtxzcystxzc;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 红外原始图像侦察数据 DO
 *
 * @author 芋道源码
 */
@TableName("hwtxzc_ystxzc")
@KeySequence("hwtxzc_ystxzc_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HwtxzcystxzcDO {

    /**
     * 红外数据标识
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 国家及地区
     */
    private String countryRegionName;
    /**
     * 影像大小
     */
    private String imageSize;
    /**
     * 拍摄日期
     */
    private String dayKey;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 分辨率
     */
    private String resolution;
    /**
     * 类型
     */
    private String fileType;
    /**
     * 格式
     */
    private String fileFormat;
    /**
     * 背景场景
     */
    private String background;
    /**
     * 光照条件
     */
    private String lightCondition;
    /**
     * 拍摄设备
     */
    private String sensorType;
    /**
     * 视角
     */
    private String perspective;
    /**
     * 来源类别
     */
    private String dataSource;
    /**
     * 来源网页
     */
    private String source;
    /**
     * 来源时长
     */
    private String videoLength;
    /**
     * 视频帧率
     */
    private String videoFps;
    /**
     * 视频中目标出现时段
     */
    private String targetAppearTime;
    /**
     * 本地存储路径
     */
    private String storageLocation;
    /**
     * 审阅状态
     */
    private String reviewStatue;

    private String sourceNet;

    private String updateTime;

}