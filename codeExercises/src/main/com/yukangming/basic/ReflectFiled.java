package com.yukangming.basic;

import java.lang.reflect.Field;

public class ReflectFiled {

    public static void main(String[] args) throws Exception {
        Class <?> clazz = Class.forName(Student.class.getName());
        Field field = clazz.getField("age");
        System.out.println(field);

        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f.getDeclaringClass());
        }

        System.out.println("=================");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f.getDeclaringClass());
        }

        Field desc = clazz.getDeclaredField("desc");
        System.out.println(desc);

        System.out.println("=================");


        Student st = (Student) clazz.newInstance();
        Field ageField = clazz.getField("age");
        ageField.set(st, 18);
        Field nameField = clazz.getField("name");
        nameField.set(st, "yukangming");

        Field descField = clazz.getDeclaredField("desc");
        descField.set(st, "i am a student");
        Field scoreField = clazz.getDeclaredField("score");
        scoreField.setAccessible(true);
        scoreField.set(st,95);
        System.out.println(scoreField.get(st));

        System.out.println(st.toString());
        System.out.println("=================");

    }
}

class Person {
    public int age;
    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person {
    public String desc;
    private int score;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "desc='" + desc + '\'' +
                ", score=" + score +
                '}';
    }
}
