package main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class JDBCPool {
    private static final String DB_URL = "jdbc:mysql://localhost/database?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    private static final int initCount = 5;
    private static final int maxCount = 10;
    private int currentCount = 0;
    private LinkedList<Connection> connectionPool = new LinkedList<Connection>();

    public JDBCPool() {
        try {
            for (int i = 0; i < initCount; i++) {
                currentCount++;
                connectionPool.add(createConnection());
            }
        } catch (SQLException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Connection getConnection() throws SQLException {
        synchronized (connectionPool) {
            if (connectionPool.size() > 0) {
                return connectionPool.removeFirst();
            }
            if (currentCount < maxCount) {
                currentCount++;
                return createConnection();
            }
        }
        throw new SQLException("Not Enough Connection");
    }

    public void free(Connection conn) {
        connectionPool.add(conn);
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }
}
