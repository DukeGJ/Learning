package Test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;

import java.util.Date;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = new User("James", new Date(), 10005);
        userDao.addUser(user);
        User res = userDao.getUser("James");
        System.out.println(res);
        res.setMoney(35000);
        userDao.updateUser(res);
        res = userDao.getUser(res.getId());
        System.out.println(res);
        userDao.deleteUser(res);
        res = userDao.getUser(res.getId());
        System.out.println(res);
    }
}
