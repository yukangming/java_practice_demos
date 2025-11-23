package com.yukangming.basic;

import com.yukangming.basic.constructer.Customer;
import com.yukangming.beanpost.Category;
import com.yukangming.factorybean.ConnectionFactory;
import com.yukangming.factorybean.ConnectionFactoryBean;
import com.yukangming.proxy.OrderService;
import com.yukangming.proxy.OrderServiceImpl;
import com.yukangming.proxy.OrderServiceProxy;
import com.yukangming.proxy.UserServiceProxy;
import com.yukangming.scope.Account;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

//@SpringBootTest
public class BasicApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = "+person);
    }

    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        Person person = ctx.getBean("person", Person.class);
//        System.out.println("person = " + person);
//        Person person = ctx.getBean(Person.class);
//        System.out.println("person =" + person);
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println("beanDefinitionName = " + beanDefinitionName);
//        }

//        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
//        for (String id : beanNamesForType) {
//            System.out.println("id = " + id);
//        }

//        if (ctx.containsBeanDefinition("person")) {
//            System.out.println("true = "+true);
//        }else {
//            System.out.println("false = " + false);
//        }

        if (ctx.containsBean("person")) {
            System.out.println("true = " + true);
        }else {
            System.out.println("false = " +false);
        }
    }

    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("id = " + beanDefinitionName);
        }
    }

    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Object person2 = ctx.getBean("person2");
        System.out.println("person2 = "+person2);
    }

    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");

        System.out.println("person = "+person);
    }

    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        String[] emails = person.getEmails();
        for (String email : emails) {
            System.out.println("email = "+email);
        }

        System.out.println("-----------------------------");
        Set<String> tels = person.getTels();
        for (String tel : tels) {
            System.out.println("tel = "+tel);
        }

        System.out.println("============================");
        List<String> addresses = person.getAddresses();
        for (String address : addresses) {
            System.out.println("address = "+address);
        }

        System.out.println("==================");
        Map<String, String> qqs = person.getQqs();
        Set<String> keys = qqs.keySet();
        for(String key : keys) {
            System.out.println("key = "+ key +" and value = "+qqs.get(key));
        }

        System.out.println("=================");
        Properties p = person.getP();
        System.out.println("the value of key1 is " +p.getProperty("key1"));
    }


    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        userService.register(new User("yukangming", "123456"));
        userService.login("kangkang", "9898987");
    }

    @Test
    public void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");

        System.out.println("customer is "+customer);
    }

    @Test
    public void test9() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        Connection conn2 = (Connection) ctx.getBean("conn");

        System.out.println("conn is "+ conn);
        System.out.println("conn is "+ conn2);

    }


    @Test
    public void test10() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");

        System.out.println("conn is "+ conn);
//        Connection object = (Connection) conn.getObject();
//        object.close();
    }

    @Test
    public void test11() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("hahah the error is here");
        System.out.println(conn);

    }

    @Test
    public void test12() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account1 = (Account) ctx.getBean("account");
        Account account2 = (Account) ctx.getBean("account");
        System.out.println(account1);
        System.out.println(account2);
    }

    @Test
    public void test13() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Object product = ctx.getBean("product");
        ctx.close();
    }

    @Test
    public void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println(conn);
    }

    @Test
    public void test15() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        com.yukangming.convertor.Person person = (com.yukangming.convertor.Person) ctx.getBean("person");
        System.out.println(person.getBirthday());
    }

    @Test
    public void test16() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext3.xml");
        Category category = (Category) ctx.getBean("category");
        System.out.println("name is "+category.getName());
    }

    @Test
    public void test17() {
        UserService userService = new UserServiceProxy();
        userService.login("yukangming", "123456");
        userService.register(new User());
        System.out.println("--------------");

        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();

    }

    @Test
    public void  test18() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService1");

        userService.login("yukangming", "111111");
        userService.register(new User());
    }

    @Test
    public void test19() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
        com.yukangming.factory.UserService userService = (com.yukangming.factory.UserService) ctx.getBean("userService");
        userService.login("yukangming", "77777");
        userService.register(new User());
    }

    @Test
    public void test20() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext5.xml");
        com.yukangming.aspect.UserService userService = (com.yukangming.aspect.UserService) ctx.getBean("userService");
        userService.login("yukangming", "77777");
        userService.register(new User());
    }

    @Test
    public void test21() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext();

    }




}
