package main.impl;

import main.service.HelloWorld;

public class SpringHelloWorld implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Spring say hello!");
    }
}
