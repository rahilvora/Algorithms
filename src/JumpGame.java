/**
 * Created by rahilvora on 7/12/16.
 */
public class JumpGame {
    public static void main(String args[]){
        int[] nums = {3,2,1,0,4};
        int[] nums1 = {2,5,0,0};
        int[] nums2 = {0 ,1};
        System.out.print(new JumpGame().canJump(nums1));
    }
    public boolean canJump(int[] nums){
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;

    }
}
