import java.util.*;

public class BubbleSort {
    // private static void sort(int[] array) {
    //     int tmp = 0;
    //     for(int i=0; i<array.length; i++){
    //         for(int j = 0; j<array.length-i-1; j++){
    //             if(array[j]>array[j+1]){
    //                 tmp = array[j];
    //                 array[j] = array[j+1];
    //                 array[j+1] = tmp;
    //             }
    //         }
    //     }
    // }

    // private static void sort(final int[] array) {
    //     int tmp = 0;
    //     for (int i = 0; i < array.length; i++) {
    //         boolean isSorted = true;
    //         for (int j = 0; j < array.length - i - 1; j++) {
    //             if (array[j] > array[j + 1]) {
    //                 tmp = array[j];
    //                 array[j] = array[j + 1];
    //                 array[j + 1] = tmp;
    //                 isSorted = false;
    //             }
    //         }
    //         if (isSorted)
    //             break;
    //     }
    // }


    private static void sort(int[] array) {
        int tmp =0;
        int lastExchangeIndex = 0;
        int sortBorder = array.length-1;
        for(int i =0; i<array.length; i++){
            boolean isSorted = true;
            for(int j = 0; j<sortBorder;j++){
                if(array[j]>array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted)
            break;
        }
    }

    public static void main(final String[] args) {
        final int[] array = new int[] { 4, 5, 3, 2, 1, 6 };
        sort(array);
        System.out.println(Arrays.toString(array));
    } 
}