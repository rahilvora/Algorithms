import java.util.Arrays;

/**
 * Created by rahilvora on 7/16/16.
 */
public class MissingNumber {
    public static void main(String args[]){
        int[] arr = {0,1,2};
        System.out.print(new MissingNumber().missingNumber1(arr));
    }

    // My approach
    public int missingNumber(int[] nums){
        int data = 0;
        Arrays.sort(nums);
        if(nums.length > 1){
            for(int i = 1; i < nums.length; i++){
                if(nums[i] - nums[i-1] > 1){
                    data = nums[i] - 1;
                }
            }
            if(data == 0 && nums[0] > 0){
                data = nums[0] - 1;
            }
            else if(data == 0){
                data = nums[nums.length -1] + 1;
            }

        }
        else if(nums.length == 1){
            if(nums[0] == 0){
                data = 1;
            }
            else{
                data = nums[0] - 1;
            }
        }
        return data;
    }

    // Optimal bit manipulation approach
    public int missingNumber1(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
