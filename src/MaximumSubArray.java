/**
 * Created by rahilvora on 2/9/17.
 */
public class MaximumSubArray {
    public static void main(String args[]){

    }
    public int maxSubArray(int nums[]){
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
