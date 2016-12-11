import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rahilvora on 11/26/16.
 */
public class palindromePairs {
    public static void main(String args[]){
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        new palindromePairs().palindromePairs(words);
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        int size = words.length;
        for(int i = 0; i < size; i++){
            map.put(words[i], i);
        }
        for(int j = 0; j < size; j++){
            int l = 0, r = 0;
            while(l <= r){
                String s = words[j].substring(l,r);
                Integer n = map.get(new StringBuffer(s).reverse().toString());
                if(n != null && j != n && palindromeCheck(words[j].substring(l == 0 ? r:0, l == 0 ? words[j].length():l))){
                    list.add(Arrays.asList(l == 0? new Integer[]{j,n}:new Integer[]{n,j}));
                }
                if(r < words[j].length())r++;
                else l++;
            }
        }
        return list;
    }

    public boolean palindromeCheck(String s1){
        int size = s1.length();
        for(int i = 0; i < size / 2; i++){
            if(s1.charAt(i) != s1.charAt(size - 1 - i)) return false;
        }
        return true;
    }
}
