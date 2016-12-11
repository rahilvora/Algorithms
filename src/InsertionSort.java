/**
 * Created by rahilvora on 6/20/16.
 *
 * Cormen
 * Chapter 2: Getting Started
 * Insertion Sort
 */
public class InsertionSort {
    public static void main(String[] args){
        int[]  a = {9,6,5,4,3,1};
        int[]  b = {1,2,3,4,5,6};
        insertionSAscending(a);
        System.out.println();
        insertionSDecending(b);
    }
    public static void insertionSAscending(int[] arr){
        int length = arr.length;
        int key;
        int i;
        for(int j = 1; j < length; j++){
            key = arr[j];
            i = j - 1;
            while(i >= 0 && arr[i] > key){
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i + 1] = key;
        }
        for(int k = 0; k<length; k++){
            System.out.print(arr[k] + " ");
        }
    }
    public static void insertionSDecending(int[] arr){
        int length = arr.length;
        int key;
        int i;
        for(int j = 1; j < length; j++){
            key = arr[j];
            i = j - 1;
            while(i >= 0 && arr[i] < key){
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i + 1] = key;
        }
        for(int k = 0; k<length; k++){
            System.out.print(arr[k] + " ");
        }

    }
}
