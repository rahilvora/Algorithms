import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by rahilvora on 7/15/16.
 */
public class TwoSum {
    public static void main(String args[]){
        int[] nums = {2,5,11,15,1,16};
        nums = new TwoSum().twoSumII(nums, 13);
        for(int i = 0; i < nums.length; i++ ){
            System.out.print(nums[i] + " ");
        }
    }

    //Two Pass Approach
    public int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        for(int i = 0; i < arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }
        return null;
    }

    //One Pass Approach
    public int[] twoSumII(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] {map.get(complement), i};
            }
            else{
                map.put(arr[i], i);
            }
        }
        return null;
    }
}
