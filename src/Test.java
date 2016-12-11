import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by rahilvora on 10/15/16.
 */
public class Test {
    public static void main(String args[]) {
        String word1 = "hegf";
        StringBuilder word = new StringBuilder(word1);
        ArrayList<Character> chs = new ArrayList<Character>();
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for(int i=word1.length() -1; i>0; i--) {
            if(word.charAt(i) > word.charAt(i-1)) {
                chs.add(word.charAt(i));
                indexMap.put(word.charAt(i), i);
                Collections.sort(chs);
                char temp = '{';
                for (int j=0;j<chs.size();j++) {
                    if(chs.get(j) > word.charAt(i-1)) {
                        temp = chs.get(j);
                        chs.set(j, '{');
                        break;
                    }
                }
                if( temp == '{') continue;
                chs.add(word.charAt(i-1));

                word.setCharAt(indexMap.get(temp), word.charAt(i-1));
                indexMap.put(word.charAt(i-1),indexMap.get(temp));
                word.setCharAt(i-1, temp);
                indexMap.put(word.charAt(i-1), i-1);
                break;

            } else {
                chs.add(word.charAt(i));
                Collections.sort(chs);
            }
        }
        System.out.print(word);
    }
}
