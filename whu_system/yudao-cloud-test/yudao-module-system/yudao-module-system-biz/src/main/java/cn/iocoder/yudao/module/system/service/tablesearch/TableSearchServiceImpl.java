package cn.iocoder.yudao.module.system.service.tablesearch;

import cn.iocoder.yudao.module.system.service.tablesearch.TableSearchService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

@Service
@DS("whu_data")
public class TableSearchServiceImpl implements TableSearchService {

    @Autowired
    private DataSource dataSource;

    @Override
    public Map<String, List<Map<String, Object>>> searchColumnInTables(String dbName, String columnName, String searchValue) {
        validateColumnName(columnName);

        Map<String, List<Map<String, Object>>> results = new LinkedHashMap<>();

        try (Connection conn = dataSource.getConnection()) {
            List<String> tables = getTables(conn, dbName);

            for (String table : tables) {
                Optional<String> matchedColumn = findMatchedColumn(conn, dbName, table, columnName);
                if (!matchedColumn.isPresent()) continue;

                List<Map<String, Object>> records = executeQuery(
                        conn,
                        String.format("SELECT * FROM `%s` WHERE `%s` = ?", table, matchedColumn.get()),
                        searchValue
                );

                if (!records.isEmpty()) {
                    results.put(table, records);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database query failed", e);
        }

        return results;
    }

    private void validateColumnName(String column) {
        if (!Pattern.matches("^[a-zA-Z_][a-zA-Z0-9_]*$", column)) {
            throw new IllegalArgumentException("Invalid column name: " + column);
        }
    }

    private List<String> getTables(Connection conn, String dbName) throws SQLException {
        List<String> tables = new ArrayList<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getTables(dbName, null, "%", new String[]{"TABLE"})) {
            while (rs.next()) {
                tables.add(rs.getString("TABLE_NAME"));
            }
        }
        return tables;
    }

    private Optional<String> findMatchedColumn(Connection conn, String dbName, String table, String targetColumn)
            throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getColumns(dbName, null, table, "%")) {
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                if (columnName.equalsIgnoreCase(targetColumn)) {
                    return Optional.of(columnName);
                }
            }
        }
        return Optional.empty();
    }

    private List<Map<String, Object>> executeQuery(Connection conn, String sql, String param)
            throws SQLException {
        List<Map<String, Object>> results = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, param);
            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(meta.getColumnName(i), rs.getObject(i));
                }
                results.add(row);
            }
        }
        return results;
    }
}