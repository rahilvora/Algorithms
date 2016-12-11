/**
 * Created by rahilvora on 10/20/16.
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String args[]){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.print(new FindMinimumInRotatedSortedArray().findMin(nums));
    }
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0,
            end = nums.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            ans = Math.min(ans , nums[mid]);
            if(nums[mid] > nums[end]){
                ans = Math.min(ans , nums[start]);
                start = mid +1;
            }
            else if(nums[start] < nums[mid]){
                ans = Math.min(ans , nums[start]);
                end = mid - 1;
            }
            else start++;

        }
        return ans;
    }
}