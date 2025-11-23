package org.example;

public class FindTest {

    public static void main(String[] args) {
        int[] arrays1 = new int[]{6, 6, 6,6, 6, 6};
        int[] array2 = new int[]{4, 6, 8, 9};
        int[] array3 = new int[]{3};
        System.out.println("结果为" + findTarget(arrays1, 6));

        System.out.println("结果为" + findTarget(array2, 10));

        System.out.println("结果为" + findTarget(array3, 3));
    }


    public static int findTarget(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                index = mid;
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return index;


    }


}
