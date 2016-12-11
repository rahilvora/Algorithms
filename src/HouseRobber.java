/**
 * Created by rahilvora on 12/9/16.
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 */
public class HouseRobber {
    public static void main(String[] args){
        int[] nums  = {50, 35, 60, 100, 150, 200, 500};
        System.out.print(new HouseRobber().rob(nums));
    }
    public int rob(int[] nums) {
        int size  = nums.length;
        if(nums == null || size == 0){
            return 0;
        }
        if(size == 1){
            return nums[0];
        }
        int[] dp = new int[size];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i = 2; i < size; i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2] + nums[i]);
        }
        return dp[size - 1];
    }
    //Without extra space
    public int rob1(int[] nums) {
        int prevMax = 0, currMax = 0;
        for(int x : nums){
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
