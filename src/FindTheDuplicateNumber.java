/**
 * Created by rahilvora on 2/9/17.
 * Algo
 * Example
 * [4, 3, 5, 6, 1, 2, 3]
 * Steps
 * 1. negate all the vaues based on indexes i.e. value = 4 - 1 = 3 therefore nums[3] = 6 = -6
 * 2. In the end index whoes value is already zero means it has a duplicate
 */
public class FindTheDuplicateNumber {
    public static void main(String args[]){

    }
    public int findDuplicate(int[] nums) {
        int answer = -1;
        for(int i = 0; i < nums.length; i++){
            int value = Math.abs(nums[i]) - 1;
            if(nums[value] > 0){
                nums[value] = -nums[value];
            }
            else{
                answer = nums[i];
            }
        }
        return Math.abs(answer);
    }
}
