import java.util.*;

/**
 * Created by rahilvora on 7/18/16.
 */
public class MajorityElement {
    public static void main(String args[]){
        int[] arr = {1,2,3,3,1,4,1,1,1};
        majority(arr);
    }
    public static int majority(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int count;
            if(map.get(nums[i]) == null){
                count = 1;
                map.put(nums[i],1);
            }
            else{
                count = map.get(nums[i]) + 1;
            }

            map.put(nums[i],count);
        }
        int key = 0;
        int maxValueInMap= Collections.max(map.values());  // This will return max value in the Hashmap
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == maxValueInMap) {
                 key = (entry.getKey());     // Print the key with max value
            }

        return key;
    }
}
