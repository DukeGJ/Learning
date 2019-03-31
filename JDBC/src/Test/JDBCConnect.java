package Test;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

public class JDBCConnect {

    public static final String DB_URL = "jdbc:mysql://localhost/database?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Logger logger = Logger.getLogger(JDBCConnect.class);

    public static void main(String[] args) {
        method1();
        method2();
    }

    /**
     * 使用Class.forName()的方式链接数据库
     */
    public static void method1() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user");
            printResult(resultSet);
        } catch (ClassNotFoundException e) {
            logger.error("register driver failed");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            dispose(connection, statement, resultSet);
        }
    }

    private static void printResult(ResultSet set) throws SQLException {
        while (set.next()) {
            int id = set.getInt(1);
            String name = set.getString(2);
            String birthday = set.getDate(3).toString();
            float money = set.getFloat(4);
            System.out.printf("id=%d\tname=%s\tbirthday=%s\tmoney=%f\n", id, name, birthday, money);
        }
    }

    /**
     * 使用DriverManager的方式链接数据库
     */
    public static void method2() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            connection = driver.connect(DB_URL, properties);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user");
            printResult(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            dispose(connection, statement, resultSet);
        }

    }

    private static void dispose(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }

    public static void method3() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user");
            printResult(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            dispose(connection, statement, resultSet);
        }
    }
}
