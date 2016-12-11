import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rahilvora on 8/30/16.
 */
public class FindTheDiff {
    public static void main(String args[]){
        System.out.print(new FindTheDiff().findTheDifference("abcde","afbcde"));
    }
    public char findTheDifference(String s, String t) {
        Set<Character> set11 = new HashSet<>();
        Set<Character> set12 = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            set11.add(s.charAt(i));
        }
        for(int j = 0; j < t.length(); j++){
            set12.add(t.charAt(j));
        }
        for(char a: set11){
            if(set12.contains(a)){
                set12.remove(a);
            }
            else{
                return a;
            }
        }
        return set12.iterator().next();
    }
    //Bit Manipulation approach
    public char findTheDifference2(String s, String t){
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }
        return c;
    }
}
