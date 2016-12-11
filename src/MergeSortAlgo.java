/**
 * Created by rahilvora on 6/20/16.
 */
public class MergeSortAlgo {
    public static void main(String[] args){
        int[] arr = {6,5,4,3,1};
        mergesort(arr, 0 , arr.length - 1);
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void mergesort(int a[], int low, int high){
        int mid;
        if(low < high){
            mid = (low + high)/2;
            mergesort(a, low , mid);
            mergesort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    public static void merge(int a[], int low, int mid, int high){
        int[] temp = new int[a.length];
        int l = low, i = low, j = mid + 1;

        while(i <= mid && j <= high){
            if(a[i]<a[j]){
                temp[l] = a[i];
                i++;
                l++;
            }
            else{
                temp[l] = a[j];
                j++;
                l++;
            }
        }
        while(i <= mid ){
            temp[l] = a[i];
            i++;
            l++;
        }

        while( j <= high){
            temp[l] = a[j];
            j++;
            l++;
        }

        for(int k = low; k <= high; k++){
            a[k] = temp[k];
        }
    }
}
