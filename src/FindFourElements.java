import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rahilvora on 9/23/16.
 */
public class FindFourElements {
    public static void main(String args[]){
        int[] nums = {3, 4, 7, 1, 2, 9, 8};
        System.out.print(new FindFourElements().findPairs(nums));
        ArrayList<Integer> arr = new ArrayList<>();
    }
    public boolean findPairs(int[] nums){
        int len = nums.length;
        HashMap<Integer,pair> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int sum = nums[i]+ nums[j];
                if(!map.containsKey(sum)){
                    map.put(sum, new pair(i,j));
                }
                else{
                    pair obj = map.get(sum);
                    System.out.println("Pair 1 "+ nums[obj.first] +" "+ nums[obj.second]);
                    System.out.println("Pair 2 "+ nums[i] +" "+nums[j]);
                    return true;
                }
            }
        }
        return false;
    }
}

class pair{
    int first, second;
    pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
