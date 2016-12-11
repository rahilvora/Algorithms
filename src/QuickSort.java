/**
 * Created by rahilvora on 6/28/16.
 */
public class QuickSort {
    public static int[] arr;
    public static void main(String args[]){
        arr = new int[]{2,8,7,1,3,5,6,4};
        QuickSort obj = new QuickSort();
        obj.sort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public void sort(int[] arr, int p, int r){

        if(p<r){
            int q = partion(arr, p, r);
            sort(arr, p, q-1);
            sort(arr, q+1, r);
        }
    }

    public int partion(int[] arr, int p , int r){
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j <= r-1; j++){
            if(arr[j] <= x){
                i = i + 1;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }
}
