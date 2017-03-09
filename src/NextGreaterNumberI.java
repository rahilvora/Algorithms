import java.util.Stack;

/**
 * Created by rahilvora on 2/18/17.
 */
public class NextGreaterNumberI {
    public static void main(String args[]){
        int[] findNums = {4,1,2};
        int[] nums = {1,3,4,2};
        new NextGreaterNumberI().nextGreaterElement(findNums, nums);
    }
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int size = findNums.length;
        int sizeII = nums.length;
        int[] answer = new int[size];
        int index = 0;
        boolean flag = false;
        for(int i = 0; i < size; i++){
            int currentValue = findNums[i];
            for(int j = 0; j < sizeII; j++){
                if(currentValue == nums[j]){
                    flag = true;
                }
                if(currentValue < nums[j] && flag){
                    answer[index] = nums[j];
                    flag = false;
                }
            }
            if(flag){
                answer[index] = -1;
                flag = false;
            }
            index++;
        }
        return answer;
    }
}
