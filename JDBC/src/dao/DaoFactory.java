package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();
    private UserDao userDao;

    private DaoFactory() {
        Properties properties = new Properties();
        File file = new File("daoConfig.properties");
        try {
            InputStream stream = new FileInputStream(file);
            properties.load(stream);
            Class cl = Class.forName(properties.getProperty("userDaoClass"));
            userDao = (UserDao) cl.newInstance();
        } catch (IOException ex) {
            throw new ExceptionInInitializerError(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    private static DaoFactory getInstance() {
        return INSTANCE;
    }

    private UserDao getUserDao() {
        return userDao;
    }
}
