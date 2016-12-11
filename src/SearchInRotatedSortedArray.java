/**
 * Created by rahilvora on 10/20/16.
 */
public class SearchInRotatedSortedArray {
    public static void main(String args[]){
        int[] nums = {1,1,3,1};

        System.out.println(new SearchInRotatedSortedArray().search2(nums, 3));
    }
    //O(N) solution
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) return i;
        }
        return -1;
    }
    //O(Log N) solution
    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if(nums[start] <= nums[mid]){
                if(target < nums[mid] &&  target >= nums[start]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            if(nums[mid] <= nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }



}
