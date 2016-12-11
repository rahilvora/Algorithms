/**
 * Created by rahilvora on 8/5/16.
 */
public class LengthOfLastWord {
    public static void main(String args[]){
        System.out.print(new LengthOfLastWord().lengthOfLastWord(" "));
    }
    public int lengthOfLastWord(String s) {
        String[] strarr = s.split(" ");
        if(strarr.length != 0)
            return strarr[strarr.length - 1].length();
        else
            return 0;
    }
}
