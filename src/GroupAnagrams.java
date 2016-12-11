import java.util.*;

/**
 * Created by rahilvora on 11/9/16.
 */
public class GroupAnagrams {
    public static void main(String[] args){
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new GroupAnagrams().groupAnagrams(str);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            char[] ch = temp.toCharArray();
            Arrays.sort(ch);
            if (map.containsKey(String.valueOf(ch))) {
                map.get(String.valueOf(ch)).add(strs[i]);
            } else {
                List<String> each = new ArrayList<>();
                each.add(strs[i]);
                map.put(String.valueOf(ch), each);
            }
        }
        for (List<String> item: map.values()) {
            res.add(item);
        }
        return res;
    }
}
