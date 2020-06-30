import java.util.Arrays;

public class HeapSort {
    
    private static void heapify(int[] array, int currentRootNode, int size) {
        if(currentRootNode < size){
            int left = 2 * currentRootNode +1;
            int right = 2 * currentRootNode +2;
            int max = currentRootNode;
            if(left < size && array[max] < array[left]){
                max = left;
            }
            if(right <size && array[max] <array[right]){
                max = right;
            }

            if(max != currentRootNode){
                int temp = array[max];
                array[max] = array[currentRootNode];
                array[currentRootNode] = temp;

                heapify(array, max, size);
            }
        }
    }


    private static void buildHeap(int[] array, int size) {
        for(int i = (size - 1)/2; i >= 0;i--)
            heapify(array, i, size);
    }

    private static void sort(int[] array) {
        int index = array.length - 1;
        for(int i = 0; i < array.length; i++){
            buildHeap(array, array.length - i);
            int temp = array[0];
            array[0] = array[index - i];
            array[index - i] = temp;
        }
    }

    public static void main(String[] args) {
        final int[] array = new int[] { 4, 5, 3, 2, 1, 6 };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}