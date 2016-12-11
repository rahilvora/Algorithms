/**
 * Created by rahilvora on 7/19/16.
 */
public class RemoveDuplicates {
    public static void main(String args[]){
        int[] arr = {1,1,2,3,3,4,5};
        new RemoveDuplicates().removeDuplicates(arr);

    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
