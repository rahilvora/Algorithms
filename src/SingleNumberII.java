import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahilvora on 7/28/16.
 */
public class SingleNumberII {
    public static void main(String args[]){
        int[] a = {1,1,1,2,2,2,3,4,4,4};
        System.out.print(new SingleNumberII().singleNumber2(a));
    }

    //HashMap approach
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int a = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry:
                map.entrySet()) {
            if(entry.getValue() == 1){
                a = entry.getKey();
            }
        }
        return a;
    }

    //Bit Manipulation approach

    public int singleNumber2(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

}
