package main.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    private static final String DB_URL = "jdbc:mysql://localhost/database?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Logger log = Logger.getLogger(JDBCUtil.class);
    private static JDBCPool pool = new JDBCPool();
    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException ex) {
            log.error("load jdbc driver failed", new ExceptionInInitializerError(ex));
        }
    }

    private JDBCUtil() {
    }

    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public static void dispose(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException ex) {

        }
        try {
            if (st != null)
                st.close();
        } catch (SQLException ex) {

        }
        if (conn != null)
            pool.free(conn);
    }
}
