import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahilvora on 2/5/17.
 * The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
 * In this way all the numbers that we have seen will be marked as negative.
 * In the second iteration, if a value is not marked as negative, it implies we have never seen that index before,
 * so just add it to the return list.
 * 
 * Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 */
public class FindAllDisappearedNumbers {
    public static void main(String args[]){
        int[] arr = {4,3,2,7,8,2,3,1};
        new FindAllDisappearedNumbers().findDisappearedNumbers(arr);
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                arr.add(i+1);
            }
        }
        return arr;
    }

}
