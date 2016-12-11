/**
 * Created by rahilvora on 7/15/16.
 * Given input array nums = [3,2,2,3], val = 3
 Your function should return length = 2, with the first two elements of nums being 2.
 */

public class RemoveElement {
    public static void main(String args[]){
        int[] arr = {3,2,2,3};
        int[] arr1 = {1};
        int val = 1;
        System.out.print(new RemoveElement().removeElement(arr1, val));
    }
    public int removeElement(int[] nums, int val){
        int count = 0;
        int index = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == val){
                count++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val && nums[index] != val){
                index++;
            }
            else if(nums[index] == val
                    && i != index
                    && nums[i] != nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }

        return nums.length - count;
    }


}
