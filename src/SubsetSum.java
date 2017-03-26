/**
 * Created by rahilvora on 2/26/17.
 */
public class SubsetSum {

    public static void main(String args[]){
        int[] nums = {2,3,7,8};
        System.out.print(new SubsetSum().subsetSum(nums, 11));
    }
    public boolean subsetSum(int[] nums, int sum){
        boolean[][] answer = new boolean[nums.length + 1][sum + 1];

        for(int i = 0; i < nums.length; i++){
            answer[i][0] = true;
        }

        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= sum; j++){
                if(j - nums[i-1] >= 0){
                    answer[i][j] = answer[i-1][j] || answer[i-1][j - nums[i-1]];
                }
                else{
                    answer[i][j] = answer[i-1][j];
                }
            }
        }
        return answer[nums.length][sum];
    }
}
