package Test;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

import java.util.Date;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user = new User("DaoFactory", new Date(), 10005);
        userDao.addUser(user);
        User res = userDao.getUser("DaoFactory");
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
