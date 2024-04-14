package org.example;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 跟着深入理解java虚拟机的例子
 * 主要是触发oom
 */
public class HeapOOM {

    static class OOMObject{}


    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            Array.newInstance(String.class, 10);
        }
    }
}
