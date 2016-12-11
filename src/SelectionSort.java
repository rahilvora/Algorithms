/**
 * Created by rahilvora on 6/20/16.
 */
public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {6,5,4,3,2};
        selectionS(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void selectionS(int[] arr){
        int length = arr.length;
        int min, temp;
        for(int i = 0; i < length; i++){
            min = i;
            for(int j = i + 1; j < length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
