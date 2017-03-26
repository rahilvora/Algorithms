/**
 * Created by rahilvora on 8/5/16.
 */
public class LengthOfLastWord {
    public static void main(String args[]){
        System.out.print(new LengthOfLastWord().lengthOfLastWordII("Hello World"));
    }
    public int lengthOfLastWord(String s) {
        String[] strarr = s.split(" ");
        if(strarr.length != 0)
            return strarr[strarr.length - 1].length();
        else
            return 0;
    }

    public int lengthOfLastWordII(final String a) {
        int i;
        if(a.length() == 0) return 0;
        int n = a.length();
        int lastWordIndex = n;
        int endIndex  = n;
        i = n-1;
        while(i >=0 && a.charAt(i) == ' '){
            i--;
        }
        endIndex = i;
        for(; i>=0;i--){
            if(a.charAt(i) == ' '){
                break;
            }
            lastWordIndex = i;
        }
        return Math.max(0, endIndex-lastWordIndex+1);

    }
}
