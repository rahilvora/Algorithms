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
        Map<Character, Character> map = new HashMap<>();
        if(s1 == null || s1.length()<=1) return true;
        for(int i = 0; i < s1.length(); i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(map.containsKey(a)){
                if(!map.get(a).equals(b)){
                    return false;
                }
            }
            else{
                if(!map.containsKey(b)){
                    map.put(a,b);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
