import java.util.ArrayList;

/**
 * Created by rahilvora on 7/19/16.
 */
public class PlusOne {
    public static void main(String args[]){
        int[] arr = {5,6,2,0,0,4,6,2,4,9};
        int[] arr1 = {9,9,9};
        new PlusOne().plusOne(arr1);
    }
    // My approach
    public int[] plusOne(int[] digits){
        int len = digits.length -1;
        int carry = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while (len > -1){
            int num;
            if(len == digits.length -1){
                num = digits[len] + 1;
            }
            else{
                num = digits[len] + carry;
            }
            nums.add(num % 10);
            carry = num /10;
            len--;
        }
        if(carry != 0){
            nums.add(carry);
        }
        int[] newArr = new int[nums.size()];
        int startIndex = newArr.length - 1;
        for (int a :
             nums) {
            newArr[startIndex] = a;
            startIndex--;
        }
        return newArr;
    }

    //Better optimal approach
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
