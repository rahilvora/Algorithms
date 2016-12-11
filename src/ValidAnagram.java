import java.util.HashMap;

/**
 * Created by rahilvora on 7/25/16.
 */
public class ValidAnagram {
    public static void main(String args[]){
        //System.out.print(new ValidAnagram().isAnagram("anagram","nagaram"));
        System.out.print(new ValidAnagram().isAnagram("aacc","ccac"));
    }
    public boolean isAnagram(String s, String t) {

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }
        else{
            for(int i = 0; i < s.length(); i++){
                if(map1.get(s.charAt(i)) ==  null){
                    map1.put(s.charAt(i),1);
                }
                else{
                    int a = map1.get(s.charAt(i));
                    map1.put(s.charAt(i),++a);
                }
                if(map2.get(t.charAt(i)) ==  null){
                    map2.put(t.charAt(i),1);
                }
                else{
                    int b = map2.get(t.charAt(i));
                    map2.put(t.charAt(i),++b);
                }
            }
        }
        return map1.equals(map2);
    }
}
