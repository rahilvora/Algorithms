import java.util.HashMap;

/**
 * Created by rahilvora on 2/17/17.
 */
public class LogestSubstringWithoutRepearingChar {
    public static void main(String args[]){
        System.out.print(new LogestSubstringWithoutRepearingChar().lengthOfLongestSubstring("aab"));
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> setOfCharacters = new HashMap<>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(setOfCharacters.containsKey(currentChar)){
                j = Math.max(j, setOfCharacters.get(currentChar) + 1);
            }
            setOfCharacters.put(currentChar,i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
