import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahilvora on 10/20/16.
 */
public class AllPossibleSubsets {
    public static void main(String args[]){
        int[] nums = {1,2,3};
        new AllPossibleSubsets().subsets(nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int size = nums.length;
        for(int i = 0; i < (1 << size); i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < size; j++){
                if((i & (1 << j)) > 0){
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
