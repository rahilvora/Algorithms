import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rahilvora on 9/4/16.
 */
public class WordPattern {
    public static void main(String args[]){
        System.out.print(new WordPattern().wordPattern2("abba","dog cat cat dog"));
    }
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map = new HashMap<>();
        char[] patterns = pattern.toCharArray();
        String[] strings = str.split(" ");
        if(patterns.length != strings.length)
            return false;
        for(int i = 0; i < pattern.length(); i++){
            if(map.containsKey(patterns[i])){
                if(!map.get(patterns[i]).equals(strings[i])){
                    return false;
                }
            }
            else{
                map.put(patterns[i],strings[i]);
            }
        }
        return true;
    }
    public boolean wordPattern2(String pattern, String str){
        Set<Character> pset = new HashSet<>();
        Set<String> strset = new HashSet<>();
        char[] patterns = pattern.toCharArray();
        String[] strings = str.split(" ");

        if(patterns.length != strings.length)
            return false;

        for(int i = 0; i < pattern.length(); i++){
            if(pset.add(patterns[i]) != strset.add(strings[i])){
                return false;
            }
        }
        return true;
    }
}
