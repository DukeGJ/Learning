package main;

import main.entity.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
    String path = "bean.xml";
    public static void main(String[] args){
        App app = new App();
        app.test1();
        app.test2();
        app.test3();
        app.test4();
    }

    //通过类路径的方式加载XML文件
    public void test1(){
        System.out.println("通过ClassPath加载XML文件创建Bean");
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        System.out.println(context.getBean("user"));
        System.out.println( context.getBean("user1"));
    }
    //通过BeanFactory方式加载XML文件
    public void test2(){
        System.out.println("通过BeanFactory加载XML文件创建Bean");
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(path));
        System.out.println(beanFactory.getBean("user"));
        System.out.println(beanFactory.getBean("user1"));
    }
    //通过静态工厂的方式装配bean
    public void test3(){
        System.out.println("通过静态工厂的方式创建Bean");
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        System.out.println(context.getBean("userStaticFactory", User.class));
    }
    //通过实例工厂的方式装配Bean
    public void test4(){
        System.out.println("通过实例工厂的方式创建Bean");
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        System.out.println(context.getBean("user3", User.class));
    }
}
