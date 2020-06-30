import java.util.Arrays;

public class ShellSort {
    
    private static void sort(int[] array) {
        for(int step = array.length / 2; step > 0; step /= 2){
            for(int i = step; i < array.length; i++){
                // int j = i;
                // int temp = array[j];
                // while(j - step >=0 && array[j - step] > temp){
                //     array[j] = array[j - step];
                //     j = j - step;
                // }
                // array[j] = temp;
                
                int value = array[i];
                int j = i - step;
                for(; j >= 0 && value < array[j]; j -= step){
                    array[j + step] = array[j];
                }
                array[j + step] = value;
            }
        }
    }

    public static void main(String[] args) {
        final int[] array = new int[] { 4, 5, 3, 2, 1, 6 };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}