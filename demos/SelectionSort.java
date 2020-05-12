import java.util.Arrays;

public class SelectionSort {
    private static void sort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            int minIndex=i;
            for(int j = i+1;j<array.length;j++){
                minIndex=array[minIndex]<array[j]?minIndex:j;
            }
            int temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
    }
    
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 3, 2, 1, 6 };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}