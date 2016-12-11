import java.util.*;

/**
 * Created by rahilvora on 11/9/16.
 */
public class findDisappearedNumbers {
    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        new findDisappearedNumbers().findDisappearedNumbers(nums);
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> arr = new ArrayList<>();
        int start = nums[0];
        for(int i = 1; i <  nums.length; i++){
            if(nums[i] - 1 > start){
                int value = nums[i];
                while(value - 1 > start){
                    arr.add(value - 1);
                    value--;
                }
            }
            start = nums[i];
        }
        Collections.sort(arr);
        return arr;
    }
}
