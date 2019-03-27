import org.apache.log4j.Logger;

import java.sql.*;

public class CRUD {
    private static Logger log = Logger.getLogger(CRUD.class);

    public static void main(String[] args) {

        System.out.println("before create");
        read();
        create();
        System.out.println("after create");
        read();


        System.out.println("before update");
        read();
        update();
        System.out.println("after update");
        read();


        System.out.println("before delete");
        read();
        delete();
        System.out.println("after delete");
        read();

    }

    static void create() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert user (id,name,birthday,money) value (4,'James','1992-06-03',3000.5)");
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }

    }

    static void read() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from user");
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                double money = rs.getDouble("money");
                System.out.println("id=" + id + " name=" + name + " birthday=" + birthday + " money=" + money);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
    }

    static void update() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("update user set money = 1000.4 where id = 4");
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
    }

    static void delete() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("delete from user where id = 4");
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
    }
}
