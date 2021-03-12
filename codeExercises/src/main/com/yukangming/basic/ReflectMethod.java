package com.yukangming.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethod {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName(Circle.class.getName());
        Method method = clazz.getMethod("draw", int.class, String.class);
        System.out.println("method:" + method);

        System.out.println("=================");

        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println("m is :" + m);
        }
        System.out.println("=================");

        Method drawCircle = clazz.getDeclaredMethod("drawCircle");
        System.out.println(drawCircle);

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }

        Circle circle = (Circle) clazz.newInstance();
        Method draw = clazz.getMethod("draw", int.class, String.class);
        draw.invoke(circle, 16, "square");

        System.out.println("=================");

        Method drawCircle1 = clazz.getDeclaredMethod("drawCircle");
        drawCircle1.setAccessible(true);
        drawCircle1.invoke(circle);
        System.out.println("=================");

        Method getAllCount = clazz.getMethod("getAllCount");
        Integer count = (Integer) getAllCount.invoke(circle);
        System.out.println(count);
    }
}

    class Shape {
        public void draw(){
            System.out.println("draw");
        }

        public void draw(int count , String name){
            System.out.println("draw "+ name +",count="+count);
        }

    }
    class Circle extends Shape {

        private void drawCircle() {
            System.out.println("drawCircle");
        }

        public int getAllCount() {
            return 100;
        }
    }
