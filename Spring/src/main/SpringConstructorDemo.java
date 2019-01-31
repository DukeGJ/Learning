package main;

import main.impl.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConstructorDemo {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConstructor.xml");
        Developer developer = (Developer) context.getBean("developer");
        System.out.println(developer.getLanguage().getName());
    }
}
