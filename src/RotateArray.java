/**
 * Created by rahilvora on 7/19/16.
 */
public class RotateArray {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7};
        new RotateArray().rotate1(arr,3);
    }

    // My approach O(n^2)
    public void rotate(int[] nums, int k){
        int len = nums.length;
        int temp;
        while(k > 0){
            temp = nums[len -1];
            for(int i = len - 1; i >0 ; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
        for(int j = 0; j < nums.length; j++){
            System.out.print(nums[j]+ " ");
        }
    }

    // Optimal SOlution
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        for(int j = 0; j < nums.length; j++){
            System.out.print(nums[j]+ " ");
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
