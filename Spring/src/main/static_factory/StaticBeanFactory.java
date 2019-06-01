package main.static_factory;

import main.entity.User;

public class StaticBeanFactory {
    public static User createUser(){
        return new User();
    }
}
