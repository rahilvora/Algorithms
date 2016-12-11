/**
 * Created by rahilvora on 12/9/16.
 */
public class HouseRobberII {
    public static void main(String args[]){
        int[] nums  = {1 , 1, 1};
        System.out.print(new HouseRobber().rob(nums));
    }
    public int rob(int[] nums) {
        int size = nums.length;
        if(nums == null || size == 0){
            return 0;
        }
        if(size == 1){
            return nums[0];
        }
        int max1 = robHelper(nums, 0, size - 2);
        int max2 = robHelper(nums, 1, size - 1);
        return Math.max(max1,max2);
    }
    public int robHelper(int[] num, int i, int j){
        if(i == j){
            return num[i];
        }
        int[] dp = new int[num.length];
        dp[i] = num[i];
        dp[i+1] = Math.max(dp[i], num[i+1]);

        for(int k = 2; k < num.length; k++){
            dp[k] = Math.max(dp[k-1], dp[k-2] + num[k]);
        }
        return dp[j];
    }
}
