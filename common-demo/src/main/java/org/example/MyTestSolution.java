package org.example;

import java.util.Stack;

public class MyTestSolution {



    public static void main(String[] args) {
        int[] array = new int[]{2,1,5};
        int[] array2 = new int[]{1,7,5,1,9,2,5,1};
        int[] array3 = new int[]{2, 7, 4, 3, 5};
        int[] solution = solution(array3);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
//        System.out.println();
    }

    public static int[] solution(int[] array) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];
        result[result.length - 1] = 0;
        stack.push(array[array.length - 1]);
        for (int i = array.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < array[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;

            }

            else {
            result[i] = stack.peek();
            }
            stack.push(array[i]);
        }

        return result;
    }
}
