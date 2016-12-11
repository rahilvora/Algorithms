import java.util.ArrayList;

/**
 * Created by rahilvora on 10/21/16.
 * Example
 * 6    8   7   4   3   2   1
 *  Algorithm
 * Step 1 : find an element which breaks the rule i.e its smaller thn its next element, In above example its 6
 * Step 2: find an element which just greater thn 6 i.e. 7 and not 8
 * Step 3: Swap 6 and 7 i.e. 7  8   6   4   3   2   1
 * Step 4: Now arrange elements to the right of i in ascending order i.e.   7   1   2   3   4   6   8
 *
 */
public class NextPermutation {
    public static void main(String args[]){
        int[] nums = {5};
        new NextPermutation().nextPermutation(nums);

    }
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        int i = size - 1;
        while (i-1 >= 0 && nums[i] <= nums[i-1]){
            i -=1;
        }
        if(i > 0){
            int j = size - 1;
            while(j >= i){
                if(nums[j] > nums[i-1]){
                    int temp = nums[j];
                    nums[j] = nums[i-1];
                    nums[i-1] = temp;
                    break;
                }
                j--;
            }
        }
        int end = size - 1;
        while (i < end){
            int temp = nums[end];
            nums[end] = nums[i];
            nums[i] = temp;
            i++;
            end--;
        }
    }
}
