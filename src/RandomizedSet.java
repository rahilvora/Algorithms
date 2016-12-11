import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rahilvora on 9/23/16.
 */
public class RandomizedSet {
    HashMap<Integer,Integer> map = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,1);
            arr.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            map.remove(val);
            arr.remove(arr.indexOf(val));
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int val = (int) Math.ceil(Math.random() * arr.size());
        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class test{
 public static void main(String args[]){
     RandomizedSet obj = new RandomizedSet();
     obj.insert(1);
     obj.insert(2);
     obj.insert(3);
     obj.remove(1);
 }
}