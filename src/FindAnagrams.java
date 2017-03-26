import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by rahilvora on 3/3/17.
 */
public class FindAnagrams {
    public static void main(String args[]){
        new FindAnagrams().findAnagrams("baa","aa");
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] chars = new int[26];
        for(char c : p.toCharArray()){
            chars[c-'a']++;
        }
        int start = 0, end = 0, count = p.length();
        while(end < s.length()){
            if(end - start == p.length() && chars[s.charAt(start++)]-'a'>=0){
                count++;
            }
            if(--chars[s.charAt(end++)] - 'a' >=0){
                count--;
            }
            if(count == 0) result.add(start);
        }
        return result;
    }
}
