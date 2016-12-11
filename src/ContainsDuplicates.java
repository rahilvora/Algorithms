import java.util.HashSet;

/**
 * Created by rahilvora on 7/16/16.
 */
public class ContainsDuplicates {
    public static void main(String args[]){
        int[] nums = {3,3};
        int[] nums1 = new int[10000];
        for(int i = 0; i < 10000; i++){
            nums1[i] = i;
        }
        System.out.print(condup(nums1));
    }
    public static boolean condup(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        if(nums.length > 1){
            for(int i = 0 ; i < nums.length ; i++){
                set.add(nums[i]);
            }
            if( set.size() < nums.length){
                return true;
            }
        }
        return false;
    }

}
