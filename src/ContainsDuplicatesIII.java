import java.util.TreeSet;

/**
 * Created by rahilvora on 11/24/16.
 * Here is the entire algorithm in pseudocode:

 Initialize an empty BST set
 Loop through the array, for each element xx
 Find the smallest element ss in set that is greater than or equal to xx, return true if s - x \leq ts−x≤t
 Find the greatest element gg in set that is smaller than or equal to xx, return true if x - g \leq tx−g≤t
 Put xx in set
 If the size of the set is larger than kk, remove the oldest item.
 Return false

 */
public class ContainsDuplicatesIII {
    public static void main(String args[]){
        int[] nums = {-1, Integer.MAX_VALUE};
        System.out.println(new ContainsDuplicatesIII().containsDuplicate(nums, 3, 5));

    }
    public boolean containsDuplicate(int[] nums, int k , int t){

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Integer successor = set.ceiling(nums[i]);

            if(successor != null && successor <= nums[i] + t) return true;

            Integer predecessor = set.floor(nums[i]);
            // Reason for doing nums[i] <= predecessor + t and not nums[i] - predecessor <= t
            // is because in case of [-1, Integer.MAX_VALUE]
            // when i is 1 and predecessor is -1 and num[i] = int_max in that case
            // nums[i] - predecessor i.e. int.max - (-1) gives int.min which is less thn t and it passed this case which
            // is not requred.
            if(predecessor != null && nums[i] <= predecessor + t) return true;

            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i = 0; i < nums.length; ++i) {
//            // Find the successor of current element
//            Integer s = set.ceiling(nums[i]);
//            if (s != null && s <= nums[i] + t) return true;
//
//            // Find the predecessor of current element
//            Integer g = set.floor(nums[i]);
//            if (g != null && nums[i] <= g + t) return true;
//
//            set.add(nums[i]);
//            if (set.size() > k) {
//                set.remove(nums[i - k]);
//            }
//        }
//        return false;
    }

}
