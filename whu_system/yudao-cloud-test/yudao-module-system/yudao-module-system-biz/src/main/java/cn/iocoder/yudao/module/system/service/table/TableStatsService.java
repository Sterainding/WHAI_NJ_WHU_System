package cn.iocoder.yudao.module.system.service.table;

import java.util.List;
import java.util.Map;

public interface TableStatsService {

    Map<String, Long> getTableStats(List<String> tableNames);

}