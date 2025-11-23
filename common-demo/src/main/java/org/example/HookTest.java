package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 练习一下jvm钩子方法,在jvm关闭后会调用注册的钩子方法
 */
public class HookTest {

    public static void main(String[] args) {
        System.out.println("开始执行主程序");
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> collect = list.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        System.out.println("使用stream流处理完列表");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("这是自定义的钩子方法，用于在jvm关闭后执行自定义逻辑")));
        System.out.println("主程序即将关闭");
    }
}
