import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahilvora on 9/20/16.
 */
public class RemoveDuplicatedFromSortedArrayII {
    public static void main(String args[]){
        int[] nums = {1,1,1,2};
        System.out.print(new RemoveDuplicatedFromSortedArrayII().removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        //define at most k times of duplicate numbers
        final int k = 2;

        //check if it is an empty array
        if(nums.length == 0) return 0;

        //start pointer of new array
        int m = 1;

        // count the time of duplicate numbers occurence
        int count = 1;

        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i - 1]) {
                if(count < k) {
                    nums[m++] = nums[i];
                }
                count++;
            } else {
                count = 1;
                nums[m++] = nums[i];
            }
        }
        return m;
    }
}
