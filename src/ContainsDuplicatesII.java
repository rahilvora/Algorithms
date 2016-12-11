import java.util.HashSet;
import java.util.Set;

/**
 * Created by rahilvora on 7/18/16.
 */
public class ContainsDuplicatesII {
    public static void main(String args[]){
        int[] arr = {1,2,1};
        System.out.print(contains(arr,1));
    }
    public static boolean contains(int[] nums, int k){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
