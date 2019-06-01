package main;

import dao.DaoFactory;
import domain.User;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        List<Map<String, Object>> result = DaoFactory.getInstance().getUserDao().getResult();
        for (Map<String, Object> map : result) {
            User user = (User) create(User.class);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String methodName = "set" + entry.getKey();
                Object value = entry.getValue();
                if ("setBirthday".equals(methodName)) {
                    value = new Date(((java.sql.Date) value).getTime());
                }
                Method[] methods = User.class.getDeclaredMethods();
                for (Method mt : methods) {
                    if (mt.getName().equals(methodName)) {
                        mt.invoke(user, value);
                    }
                }
            }
            System.out.println(user);
        }
    }

    static Object create(Class cl) throws Exception {
        return cl.newInstance();
    }
}
