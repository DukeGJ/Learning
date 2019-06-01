package main.entity;

import java.util.Date;

public class User {
    private String name;
    private int age;
    private Date birthday;
    private double money;

    public User() {
        System.out.println("执行无参构造函数");
    }

    public User(String name, int age, Date birthday, double money) {
        System.out.println("执行有参构造函数");
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", money=" + money +
                '}';
    }
}
