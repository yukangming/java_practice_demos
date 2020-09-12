package com.yukangming.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

}
