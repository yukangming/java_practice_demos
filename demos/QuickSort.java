import java.util.Arrays;

public class QuickSort {

    static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= pivot) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        final int[] array = new int[] { 4, 5, 3, 2, 1, 6 };
        sort(array, 0, 5);
        System.out.println(Arrays.toString(array));
    }
}