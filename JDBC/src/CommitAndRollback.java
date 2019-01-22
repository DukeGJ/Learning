import java.sql.*;

/**
 * 事务demo
 */
public class CommitAndRollback {
    //JDBC驱动名称
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //数据库URL
    public static final String DB_URL = "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    //用户名
    public static final String USER = "root";
    //密码
    public static final String PASS = "123456";

    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        try {
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            //连接数据库
            System.out.println("Connecting to database");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            //关闭自动提交
            connection.setAutoCommit(false);
            //STEP 5: Execute a query to create statment with
            // required arguments for RS example.
            System.out.println("Creating statement...");
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            //STEP 6: INSERT a row into Employees table
            System.out.println("Inserting one row....");
            String SQL = "INSERT INTO user " +
                    "VALUES (106, 28, 'Curry', 'Stephen')";
            statement.executeUpdate(SQL);

            //STEP 7: INSERT one more row into Employees table
            SQL = "INSERT INTO user " +
                    "VALUES (107, 32, 'Kobe', 'Bryant')";
            statement.executeUpdate(SQL);

            //STEP 8: Commit data here.
            System.out.println("Commiting data here....");
            connection.commit();

            //STEP 9: Now list all the available records.
            String sql = "SELECT id, first, last, age FROM user ";
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("List result set for reference....");
            printRs(rs);

            //STEP 10: Clean-up environment
            rs.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            // If there is an error then rollback the changes.
            System.out.println("Rolling back data here....");
            try{
                if(connection!=null)
                    connection.rollback();
            }catch(SQLException se2){
                se2.printStackTrace();
            }//end try
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
    public static void printRs(ResultSet set) throws SQLException{
        //Ensure we start with first row
        set.beforeFirst();
        while(set.next()){
            //Retrieve by column name
            int id = set.getInt("id");
            String name = set.getString("name");
            String phone = set.getString("phone");
            String pwd = set.getString("pwd");
            System.out.println("id="+id+" name="+name+" phone="+phone+ "pwd="+pwd);
        }
        System.out.println();
    }//end printRs()
}
