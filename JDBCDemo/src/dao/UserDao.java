package dao;

import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public int addUser(User user);

    public User getUser(int userId);

    public User getUser(String userName);

    public List<Map<String, Object>> getResult();

    public int updateUser(User user);

    public int deleteUser(User user);
}
