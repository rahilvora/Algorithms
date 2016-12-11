import java.util.Arrays;

/**
 * Created by rahilvora on 7/19/16.
 */
public class FindMinInRotatedSortedArray {

    public static void main(String args[]){

    }
    //My approach
    public int findMin(int[] nums){
        Arrays.sort(nums);
        return nums[0];
    }

    //Classic Binary Search Approach
    public int findMin2(int[] nums){
        int start = 0, end = nums.length -1;

        while(start < end){
            if(nums[start] > nums[end]){
                return nums[start];
            }
            int mid = (start + end) / 2;

            if(nums[mid] >= nums[start])
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
    }
}
