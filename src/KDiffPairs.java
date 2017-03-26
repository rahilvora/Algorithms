import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by rahilvora on 3/5/17.
 */
public class KDiffPairs {
    public static void main(String args[]){
        int[] nums = {1, 2, 3, 4, 5};
        System.out.print(new KDiffPairs().findPairs(nums, 1));
    }
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
