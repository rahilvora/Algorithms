/**
 * Created by rahilvora on 9/20/16.
 */
public class ReverseWordsInAString {
    public static void main(String args[]){
        System.out.print(new ReverseWordsInAString().reverseWords("the sky is blue"));
    }
    public String reverseWords(String s) {
        StringBuffer str = new StringBuffer();

        for(int start = s.length() - 1; start >= 0; start--){
            if(s.charAt(start) == ' ') continue;
            int end = start;
            while(start >= 0 && s.charAt(start) != ' ') start--;
            str.append(s.substring(start+1, end+1)).append(" ");
        }
        return str.toString().trim();
    }
}