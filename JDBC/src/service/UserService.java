package service;

import dao.DaoException;
import dao.UserDao;
import domain.User;

public class UserService {
    private UserDao userDao;

    public void addUser(User user){
        try{
            userDao.addUser(user);
        }catch (DaoException ex){
            ex.printStackTrace();
        }
    }

    public void deleteUser(User user){
        try{
            userDao.deleteUser(user);
        }catch (DaoException ex){
            ex.printStackTrace();
        }
    }

    public void updateUser(User user){
        try{
            userDao.updateUser(user);
        }catch (DaoException ex){
            ex.printStackTrace();
        }
    }

    public User findUser(int id){
        try{
           return userDao.getUser(id);
        }catch (DaoException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
