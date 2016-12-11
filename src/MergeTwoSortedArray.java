/**
 * Created by rahilvora on 9/23/16.
 */
public class MergeTwoSortedArray {

    public static void main(String args[]){
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};
        new MergeTwoSortedArray().merge(arr1, arr2, arr1.length, arr2.length);
    }
    public void merge(int ar1[], int ar2[], int m, int n){
        for(int i = n - 1; i >=0; i--){
            int last = ar1[m-1], j = m -1;
            while(ar1[j] > ar2[i]){
                ar1[j] = ar1[i];
                j--;
            }
            if(j != m-1){
                ar1[j+1] = ar2[i];
                ar2[i] = last;
            }
        }
    }
}
