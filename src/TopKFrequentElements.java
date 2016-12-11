import java.util.*;

/**
 * Created by rahilvora on 9/8/16.
 */
public class TopKFrequentElements {
    public static void main(String args[]){
        int[] nums = {1,1,1,2,2,3};
        new TopKFrequentElements().topKFrequent(nums, 2);
    }
    public void topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int a :
             nums) {
            if(!map.containsKey(a)){
                map.put(a,1);
            }
            else{
                int count = map.get(a);
                map.put(a, ++count);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int size = k;
        while(k >0){
            int value = (Collections.max(map.values()));
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                if(entry.getValue() == value){
                    arr.add(entry.getKey());
                    map.remove(entry.getKey());
                    break;
                }
            }
            k--;
        }
        System.out.print("Hello");
    }
}
