import javax.xml.transform.Result;
import java.sql.*;

public class JDBCDemo {
    //JDBC驱动名称
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //数据库URL
    public static final String DB_URL = "jdbc:mysql://localhost/test";
    //用户名
    public static final String USER = "root";
    //密码
    public static final String PASS = "123456";

    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        try {
            //注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            System.out.println("Connecting to database");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            //执行语句
            statement = connection.createStatement();
            String sql = "SELECT * from Test.user ";
            ResultSet set = statement.executeQuery(sql);
            //输出结果
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String phone = set.getString("phone");
                String pwd = set.getString("pwd");
                System.out.println("id="+id+" name="+name+" phone="+phone+ "pwd="+pwd);
            }
            set.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
