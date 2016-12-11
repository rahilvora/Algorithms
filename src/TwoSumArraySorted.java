/**
 * Created by rahilvora on 9/10/16.
 */
public class TwoSumArraySorted {
    public static void main(String args[]){
        int[] arr = {2, 7, 11, 15};
        int target = 13;
        new TwoSumArraySorted().twoSum(arr, target);
    }
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int[] ans = new int[2];

        while(low < high){
            int mid = (low + high)/2;

            if(numbers[low] + numbers[high] > target){
                high -=  1;
            }
            else if(numbers[high] + numbers[low]< target) {
                low += 1;
            }
            if(numbers[low] + numbers[high] == target){
                ans[0] = low + 1;
                ans[1] = high + 1;
                break;
            }
        }
        return ans;
    }
}
