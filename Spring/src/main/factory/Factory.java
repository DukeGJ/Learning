package main.factory;

import main.entity.User;

public class Factory {
    public  User createUser(){
        return new User();
    }
}
