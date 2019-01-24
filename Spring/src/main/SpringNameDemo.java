package main;

import main.impl.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringNameDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringName.xml");
        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer.getAddress().getFullAddress());
    }
}
