import java.util.Arrays;

public class CockTailSort {
    
    private static void sort(final int[] array) {
        int tmp = 0;
        for (int i = 0; i<array.length/2; i++) {
            boolean isSorted = true;
            for (int j = i; j<array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
            isSorted = true;
            for (int j = array.length-i-1; j>i; j--) {
                if (array[j]<array[j-1]) {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }
    }

    public static void main(final String[] args) {
        final int[] array = new int[] { 4, 5, 3, 2, 1, 6 };
         sort(array);
         System.out.println(Arrays.toString(array));
    }
}