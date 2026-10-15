package cn.iocoder.yudao.module.system.service.table;

import cn.iocoder.yudao.module.system.dal.mysql.table.TableStatsMapper;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
@DS("whu_data")
public class TableStatsServiceImpl implements TableStatsService {

    @Resource
    private TableStatsMapper tableStatsMapper;

    @Resource
    private DataSource dataSource;

    @Override
    @Transactional
    public Map<String, Long> getTableStats(List<String> tableNames) {
        if (tableNames == null || tableNames.isEmpty()) {
            return Collections.unmodifiableMap(new HashMap<String, Long>() {{
                put("totalRows", 0L);
                put("totalSize", 0L);
            }});
        }

        Long totalSize = tableStatsMapper.selectTotalSize(tableNames);
        AtomicLong totalRows = new AtomicLong(0L);

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            for (String table : tableNames) {
                try (ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + safeTable(table))) {
                    if (rs.next()) {
                        totalRows.addAndGet(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error", e);
        }

        Map<String, Long> result = new HashMap<>(2);
        result.put("totalRows", totalRows.get());
        result.put("totalSize", totalSize != null ? totalSize : 0L);
        return Collections.unmodifiableMap(result);
    }

    private String safeTable(String tableName) {
        return "`" + tableName.replace("`", "``") + "`";
    }
}