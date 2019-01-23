package main.impl;

import main.service.HelloWorld;

public class StructHelloWorld implements HelloWorld {

    @Override
    public void sayHello() {
        System.out.println("Structs Say Hello!");
    }
}
