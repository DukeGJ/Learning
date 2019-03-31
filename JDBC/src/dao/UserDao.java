package dao;

import domain.User;

public interface UserDao {

    public int addUser(User user);

    public User getUser(int userId);

    public User getUser(String userName);

    public int updateUser(User user);

    public int deleteUser(User user);
}
