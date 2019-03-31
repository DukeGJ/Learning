package dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();
    private UserDao userDao;

    private DaoFactory() {
        Properties properties = new Properties();
        try {
            InputStream stream = DaoFactory.class.getResourceAsStream("../daoConfig.properties");
            properties.load(stream);
            Class cl = Class.forName(properties.getProperty("userDaoClass"));
            userDao = (UserDao) cl.newInstance();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
