package com.yukangming.basic.constructer;

import java.io.Serializable;

/**
 * @author yukangming
 */
public class Customer implements Serializable {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
