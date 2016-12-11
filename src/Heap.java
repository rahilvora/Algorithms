/**
 * Created by rahilvora on 6/27/16.
 */
public class Heap {
    public static int[] heapArray;
    public static int heapsize;
    public static void main(String args[]){
        //heapArray = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1,19};
        heapArray = new int[]{4,1,3,2,16,9,10,14,8,7};
        Heap obj = new Heap();
        //obj.buildHeap(heapArray);
        obj.heapsort();
        for(int i = 0; i < heapArray.length;i++){
            System.out.print(heapArray[i]+" ");
        }
    }
    public void max_Heapify(int[] heapArray, int index){
        int left = left(index);
        int right = right(index);
        int largest;
        if(left < heapsize && heapArray[left] > heapArray[index]){
            largest = left;
        }
        else{
            largest = index;
        }
        if(right < heapsize && heapArray[right] > heapArray[largest]){
            largest = right;
        }
        if(largest != index ){
            int temp = heapArray[index];
            heapArray[index] = heapArray[largest];
            heapArray[largest] = temp;
            max_Heapify(heapArray,largest);
        }
    }
    public void buildHeap(int[] heapArray){
        heapsize = heapArray.length;
        for(int i = heapsize/2 - 1; i>=0; i-- ){
            max_Heapify(heapArray, i);
        }
    }
    public int left(int i){
        return 2*i + 1;
    }
    public int right(int i){
        return 2*i + 2;
    }
    public void heapsort(){
        buildHeap(heapArray);
        for(int i = heapArray.length - 1; i >= 1; i-- ){
            int temp = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = temp;
            heapsize = heapsize - 1;
            max_Heapify(heapArray,0);
        }
    }
}
