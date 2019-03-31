package domain;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private Date birthday;
    private double money;

    public User() {
    }

    public User(String name, Date birthday, double money) {
        this.name = name;
        this.birthday = birthday;
        this.money = money;
    }

    public User(int id, String name, Date birthday, double money) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", money=" + money +
                '}';
    }
}
