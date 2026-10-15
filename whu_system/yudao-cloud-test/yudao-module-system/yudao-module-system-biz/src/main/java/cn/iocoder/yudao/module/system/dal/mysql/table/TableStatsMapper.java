package cn.iocoder.yudao.module.system.dal.mysql.table;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@DS("whu_data")
@Mapper
public interface TableStatsMapper {

    Long selectTotalSize(@Param("tableNames") List<String> tableNames);

}