import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddReviewStatueColumn {

    public static void main(String[] args) {
        String url = System.getenv("WHAI_JDBC_URL");
        String user = System.getenv("WHAI_JDBC_USERNAME");
        String password = System.getenv("WHAI_JDBC_PASSWORD");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String getTablesSql = "SELECT table_name FROM information_schema.tables WHERE table_schema = DATABASE()";
            rs = stmt.executeQuery(getTablesSql);

            List<String> tables = new ArrayList<>();
            while (rs.next()) {
                tables.add(rs.getString("table_name"));
            }

            for (String table : tables) {
                String alterSql = String.format(
                        "ALTER TABLE `%s` ADD COLUMN review_statue VARCHAR(255) DEFAULT '未审阅'",
                        table
                );

                try {
                    stmt.executeUpdate(alterSql);
                    System.out.println("成功为表 [" + table + "] 添加列");
                } catch (SQLException e) {
                    System.err.println("表 [" + table + "] 添加列失败: " + e.getMessage());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
