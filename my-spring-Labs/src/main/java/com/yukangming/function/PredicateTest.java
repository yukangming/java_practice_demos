package com.yukangming.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<Integer> oddNum = num -> num % 2 == 0;
        Predicate<Integer> positiveNum = num -> num > 0;
        Integer[] integers = IntStream.rangeClosed(-10, 10).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(Arrays.stream(integers).toArray()));
        List<Integer> filter = filter(integers, oddNum);
        System.out.printf("result " + filter);
        List<Integer> filter1 = filter(integers, positiveNum);
        System.out.println("result2 " + filter1);
    }

    public static <T> List<T> filter(T[] array, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : array) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
