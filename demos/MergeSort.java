public class MergeSort{

    /**
     * 
     * @param args
     */
    public void sort(int[] array,int start,int end) {
        if(start==end) return;
        int mid=(start+end)/2;
        sort(array, start, mid);
        sort(array, mid+1, end);
        merge(array,start,mid,end);
    }

    public void merge(int[] array,int start,int mid,int end) {
        int[] temp=new int[end-start+1];
        int p1=start,p2=mid+1,p=0;
        
    }
    public static void main(String[] args) {
        
    }
}