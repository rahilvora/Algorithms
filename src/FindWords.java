import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahilvora on 3/2/17.
 */
public class FindWords {
    public static void main(String args[]){
        String[] words = {"Hello","Alaska","Dad","Peace"};
        new FindWords().findWords(words);

    }
    public String[] findWords(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        map.put("qwertyuiop",0);
        map.put("asdfghjkl",1);
        map.put("zxcvbnm",2);
        String[] ans = null;
        if(words == null || words.length == 0) return new String[0];
        for(int i = 0; i < words.length; i++){
            boolean flag = true;
            int index = -1;
            String str="";
            char[] chars = words[i].toLowerCase().toCharArray();
            char currentChar = chars[0];
            for(String key: map.keySet()){
                if(key.indexOf(currentChar)!= -1){
                    str = key;
                }
            }
            for(int j = 0; j < chars.length; j++){
                if(str.indexOf(chars[j]) ==-1){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer.add(words[i]);
            }
            ans = new String[answer.size()];
            int k = 0;
            for(String s: answer){
                ans[k] = s;
                k++;
            }
        }
        return ans;
    }
}
