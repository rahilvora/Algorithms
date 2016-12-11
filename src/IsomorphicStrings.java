import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahilvora on 9/2/16.
 */
public class IsomorphicStrings {
    public static void main(String args[]){
        System.out.print(new IsomorphicStrings().isIsomorphic("eggg","baav"));
    }
    public boolean isIsomorphic(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
}
