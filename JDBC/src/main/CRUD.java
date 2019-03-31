package main;

import domain.User;
import main.util.JDBCUtil;
import org.apache.log4j.Logger;

import java.sql.*;

public class CRUD {
    private static Logger log = Logger.getLogger(CRUD.class);

    public static void main(String[] args) {

    }

    static void create(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert user (name,birthday,money) value (?,?,?)");
            ps.setString(1, user.getName());
            ps.setDate(2, new Date(user.getBirthday().getTime()));
            ps.setDouble(3, user.getMoney());
            ps.executeUpdate();
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

    static User findUser(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("update user where id = ?");
            ps.setInt(1, userId);
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                double money = rs.getDouble("money");
                user = new User(id, name, new java.util.Date(birthday.getTime()), money);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
        return user;
    }


    static int update(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("update user set name=?, birthday=?, money=? where id = ?");
            ps.setString(1, user.getName());
            ps.setDate(2, new Date(user.getBirthday().getTime()));
            ps.setDouble(3, user.getMoney());
            ps.setInt(4, user.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
        return 0;
    }

    static int delete(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("delete from user where id = ?");
            ps.setInt(1, user.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
        return 0;
    }
}
