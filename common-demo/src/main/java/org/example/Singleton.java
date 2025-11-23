package org.example;

public class Singleton {

    public Singleton() {
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();

        static {
            System.out.println("LazyHolder instance created");
        }
    }

    private static Object getInstance(boolean flag) {
        if (flag) return new LazyHolder[2];

        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        // 说明这样没有触发类的初始化
        Object instance = getInstance(true);
        System.out.println("------");
        // 这里应用了类的静态字段，会触发类的初始化
        Object instance1 = getInstance(false);

        System.out.println("------");

    }
}
