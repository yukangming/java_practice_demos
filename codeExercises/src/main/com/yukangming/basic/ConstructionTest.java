package com.yukangming.basic;

import com.yukangming.basic.dao.User;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class ConstructionTest implements Serializable {

    public static void main(String[] args) throws Exception {
        Class <?> clazz = Class.forName(User.class.getName());
        User user1 = (User) clazz.newInstance();
        user1.setAge(25);
        user1.setName("KangmingYu");
        System.out.println(user1);

        System.out.println("====================");

        Constructor cs1 = clazz.getConstructor(String.class);
        User user2 = (User) cs1.newInstance("yukangming");
        //user2.setName("yukangming2");
        user2.setAge(55);
        System.out.println(user2);

        //Class <?> clazz = Class.forName("com.yukangming.basic.dao.User");

        System.out.println("====================");

        Constructor cs2 = clazz.getDeclaredConstructor(int.class, String.class);
        cs2.setAccessible(true);
        Object yukangming3 = cs2.newInstance(26, "yukangming3");
        User user3 = (User) yukangming3;
        System.out.println(user3);
        System.out.println("==============");

    }


    


}
