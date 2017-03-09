import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rahilvora on 2/9/17.
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String args[]){

    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        if(nums.length == 0) return duplicates;
        Arrays.sort(nums);
        int previousElement = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(previousElement == nums[i]){
                duplicates.add(nums[i]);
            }
            previousElement = nums[i];
        }
        return duplicates;
    }

}
