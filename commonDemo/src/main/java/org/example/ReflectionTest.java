package org.example;


class Animal {}
class Dog extends Animal {}
public class ReflectionTest {

    public static void main(String[] args) {


        // 这段逻辑只是我拿来测试isAssignABELFrom方法的，因为对class类型的方法都不太了解
        boolean assignableFrom = Animal.class.isAssignableFrom(Dog.class);
        boolean assignableFrom1 = Dog.class.isAssignableFrom(Animal.class);
        System.out.println(assignableFrom + "===" + assignableFrom1);


    }
}
