import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rahilvora on 9/2/16.
 */
public class ContainesDuplicate {
    public static void main(String args[]){
        int[] nums = {1,2,3,4,5,1};
        System.out.print(new ContainesDuplicate().containsDuplicate(nums));
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
