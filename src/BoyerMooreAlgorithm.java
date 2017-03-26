/**
 * Created by rahilvora on 3/9/17.
 * Majority voting algorithm or Majority Element in an array
 *
 */
public class BoyerMooreAlgorithm {
    public static void main(String args[]){
        int[] arr = {2,9,1,2,4,5,3,2,2};
        System.out.print(new BoyerMooreAlgorithm().majorityElement(arr));
    }
    public int majorityElement(int[] arr){
        int candidate = -1;
        int count = 0;
        //Step 1
        for(int num : arr){
            if(count == 0){
                candidate = num;
                count++;
            }
            else if(candidate == num){
                count++;
            }
            else{
                count--;
            }
        }
        //Step 2
        if(count == 0) return -1;
        count = 0;
        for(int num : arr){
            if(num == candidate){
                count++;
            }
        }
        if(count > arr.length/2) return candidate;
        return -1;
    }
}
