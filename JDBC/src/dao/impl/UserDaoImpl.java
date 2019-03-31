package dao.impl;

import dao.DaoException;
import dao.UserDao;
import domain.User;
import main.util.JDBCUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public int addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert user (name,birthday,money) value (?,?,?)");
            ps.setString(1, user.getName());
            ps.setDate(2, new Date(user.getBirthday().getTime()));
            ps.setDouble(3, user.getMoney());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
    }

    @Override
    public User getUser(String userName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select id,name,birthday,money from user where name = ?");
            ps.setString(1, userName);
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                user = mappingUser(rs);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
        return user;
    }

    private User mappingUser(ResultSet rs) throws SQLException {
        User user;
        int id = rs.getInt("id");
        String name = rs.getString("name");
        Date birthday = rs.getDate("birthday");
        double money = rs.getDouble("money");
        user = new User(id, name, new java.util.Date(birthday.getTime()), money);
        return user;
    }

    @Override
    public User getUser(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select id,name,birthday,money from user where id = ?");
            ps.setInt(1, userId);
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                user = mappingUser(rs);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
        return user;
    }

    @Override
    public int updateUser(User user) {
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
            throw new DaoException(ex.getMessage(), ex);
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
    }

    @Override
    public int deleteUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("delete from user where id = ?");
            ps.setInt(1, user.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        } finally {
            JDBCUtil.dispose(conn, ps, rs);
        }
    }
}
