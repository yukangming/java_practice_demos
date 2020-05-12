import java.util.*;
public class InsertionSort{
    public static void sort(int[] a, int n){
        if(n<=1) return;
        for(int i=1; i<n;i++){
            int value = a[i];
            int j = i-1;
            for(; j>=0; j--){
                if(a[j]>value){
                    a[j+1] = a[j];
                }
                else{
                    break;
                }
            }
            a[j+1] =value;
        }
    }

    public static void sort(int[] array){
        for(int i=1;i<array.length;i++){
            int insertValue=array[i];
            int j=i-1;
            for(; j>=0&&insertValue<array[j];j--){
                array[j+1]=array[j];
            }
            array[j+1]=insertValue;
        }
    }

public static void main(String[] args) {
    final int[] array = new int[] { 4, 5, 3, 2, 1, 6 };
    sort(array,6);
    System.out.println(Arrays.toString(array));
    sort(array);
    System.out.println(Arrays.toString(array));
}
}