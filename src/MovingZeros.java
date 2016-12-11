import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rahilvora on 7/18/16.
 */
public class MovingZeros {
    public static void main(String args[]){
        int[] arr = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        new MovingZeros().moveZeros2(arr);
    }

    // O(n^2)
    public void moveZeroes(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i]==0 && i+1 < len && nums[i+1] != 0){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
            if(nums[i]==0 && i+1 < len && nums[i+1] == 0){
                for(int j = i + 1; j < len; j++){
                    if(nums[j]==0 && j+1 < len && nums[j+1] != 0){
                        int temp = nums[i];
                        nums[i] = nums[j+1];
                        nums[j+1] = temp;
                        break;
                    }
                }
            }
        }
        for(int j = 0; j< len; j++){
            System.out.print(nums[j]+" ");
        }
    }

    //O(n)

    public void moveZeros2(int[] nums){
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
        for(int j = 0; j< nums.length; j++){
            System.out.print(nums[j]+" ");
        }
    }

}
