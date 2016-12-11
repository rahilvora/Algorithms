/**
 * Created by rahilvora on 7/20/16.
 */
public class SearchInsertPosition {
    public static void main(String args[]){
        int[] arr = {1};
        System.out.print(new SearchInsertPosition().searchInsert(arr, 2));
    }
    public int searchInsert(int[] nums, int target) {
        int n = 0;
        while(n <= nums.length-1 && nums[n] < target){
            n++;
        }
        return n;
    }
}
