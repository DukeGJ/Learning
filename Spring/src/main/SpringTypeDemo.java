package main;

import main.impl.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTypeDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringType.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.getAbility().getSkill());
    }
}
