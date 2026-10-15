import java.sql.*;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Random;

public class ColumnProcessor {

    // 随机User-Agent列表
    private static final String[] USER_AGENTS = {
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.1 Safari/605.1.15",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
            "Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.1 Mobile/15E148 Safari/604.1",
            "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36"
    };

    public static void main(String[] args) {
        // 设置全局SSL上下文（忽略证书验证）
        setupUnsafeSSLContext();

        String jdbcUrl = System.getenv("WHAI_JDBC_URL");
        String username = System.getenv("WHAI_JDBC_USERNAME");
        String password = System.getenv("WHAI_JDBC_PASSWORD");

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            DatabaseMetaData metaData = conn.getMetaData();

            // 获取所有表
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                processTable(conn, tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void setupUnsafeSSLContext() {
        try {
            // 创建信任所有证书的TrustManager
            TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                    }
            };

            // 创建SSLContext并初始化
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // 设置全局HttpsURLConnection的SSLSocketFactory
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            // 创建主机名验证器（信任所有主机名）
            HostnameVerifier allHostsValid = (hostname, session) -> true;
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    private static void processTable(Connection conn, String tableName) {
        try {
            // 检查是否存在数据来源列
            if (!columnExists(conn, tableName, "source")) {
                return;
            }

            // 添加新列（如果不存在）
            addColumnIfNotExists(conn, tableName, "source_net", "LONGTEXT");

            // 处理数据
            processRows(conn, tableName);

        } catch (SQLException e) {
            System.err.println("处理表 " + tableName + " 时出错: " + e.getMessage());
        }
    }

    private static boolean columnExists(Connection conn, String tableName, String columnName) throws SQLException {
        try (ResultSet rs = conn.getMetaData().getColumns(null, null, tableName, columnName)) {
            return rs.next();
        }
    }

    private static void addColumnIfNotExists(Connection conn, String tableName, String columnName, String columnType) throws SQLException {
        if (!columnExists(conn, tableName, columnName)) {
            try (Statement stmt = conn.createStatement()) {
                String sql = String.format(
                        "ALTER TABLE `%s` ADD COLUMN `%s` %s",
                        tableName, columnName, columnType
                );
                stmt.executeUpdate(sql);
                System.out.println("已为表 " + tableName + " 添加列 " + columnName);
            }
        }
    }

    private static void processRows(Connection conn, String tableName) {
        String selectSql = "SELECT id, `source` FROM `" + tableName + "`";
        String updateSql = "UPDATE `" + tableName + "` SET `source_net` = ? WHERE id = ?";

        try (Statement selectStmt = conn.createStatement();
             ResultSet rows = selectStmt.executeQuery(selectSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            conn.setAutoCommit(false); // 开启事务
            int batchSize = 0;

            while (rows.next()) {
                String id = rows.getString("id");
                String url = rows.getString("source");

                if (url == null || url.trim().isEmpty()) {
                    continue;
                }

                try {
                    String html = fetchHtmlContentWithRetry(url);
                    updateStmt.setString(1, html);
                    updateStmt.setString(2, id);
                    updateStmt.addBatch();
                    batchSize++;

                    // 每100条执行一次批量更新
                    if (batchSize % 100 == 0) {
                        updateStmt.executeBatch();
                        conn.commit();
                    }
                } catch (IOException e) {
                    System.err.printf("表 %s ID %s 处理失败: %s%n", tableName, id, e.getMessage());
                }
            }

            // 执行剩余的批量更新
            if (batchSize % 100 != 0) {
                updateStmt.executeBatch();
                conn.commit();
            }

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static String fetchHtmlContent(String urlString) throws IOException {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);

            if (url.getProtocol().equalsIgnoreCase("https")) {
                connection = (HttpsURLConnection) url.openConnection();
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000); // 增加连接超时
            connection.setReadTimeout(30000);    // 增加读取超时

            // 随机选择User-Agent
            Random random = new Random();
            String userAgent = USER_AGENTS[random.nextInt(USER_AGENTS.length)];

            // 设置完整的浏览器请求头
            connection.setRequestProperty("User-Agent", userAgent);
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            connection.setRequestProperty("Cache-Control", "max-age=0");

            // 设置Referer为Google搜索
            connection.setRequestProperty("Referer", "https://www.google.com/");

            // 添加DNT头
            connection.setRequestProperty("DNT", "1");

            // 添加Pragma头
            connection.setRequestProperty("Pragma", "no-cache");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readResponse(connection);
            } else {
                // 尝试读取错误流
                InputStream errorStream = connection.getErrorStream();
                if (errorStream != null) {
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(errorStream, StandardCharsets.UTF_8))) {
                        StringBuilder errorResponse = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            errorResponse.append(line);
                        }
                        throw new IOException("HTTP Error " + responseCode + ": " + errorResponse.toString().substring(0, Math.min(200, errorResponse.length())));
                    }
                } else {
                    throw new IOException("HTTP Error " + responseCode + " with no error body");
                }
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String readResponse(HttpURLConnection connection) throws IOException {
        // 检查内容编码
        String contentEncoding = connection.getContentEncoding();
        InputStream inputStream = connection.getInputStream();

        // 处理gzip压缩
        if ("gzip".equalsIgnoreCase(contentEncoding)) {
            inputStream = new java.util.zip.GZIPInputStream(inputStream);
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            return response.toString();
        }
    }

    private static String fetchHtmlContentWithRetry(String url) throws IOException {
        int maxRetries = 3;
        int retryDelay = 3000; // 3秒重试间隔
        IOException lastException = null;

        for (int i = 0; i < maxRetries; i++) {
            try {
                return fetchHtmlContent(url);
            } catch (IOException e) {
                lastException = e;
                System.err.println("请求失败 (" + (i+1) + "/" + maxRetries + "): " + e.getMessage());

                if (i < maxRetries - 1) {
                    try {
                        Thread.sleep(retryDelay);
                        // 指数退避 - 每次增加等待时间
                        retryDelay *= 2;
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        // 中断时退出重试
                        break;
                    }
                }
            }
        }

        // 所有重试失败后抛出异常
        if (lastException != null) {
            throw new IOException("多次重试后仍失败: " + lastException.getMessage(), lastException);
        } else {
            throw new IOException("获取URL内容时发生未知错误");
        }
    }
}