package main;

import main.service.OutputHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Common.xml");
        OutputHelper helper = (OutputHelper) context.getBean("outputHelper");
        helper.generateOutput();
    }
}
