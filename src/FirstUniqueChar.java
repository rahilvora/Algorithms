/**
 * Created by rahilvora on 8/30/16.
 */
public class FirstUniqueChar {
    int  index = 0;
    public static void main(String args[]){
        System.out.print(new FirstUniqueChar().firstUniqChar("cc"));
    }
    public int firstUniqChar(String s) {
        int ans = -1;
        for(int i = 0; i<s.length(); i++) {
            if(s.lastIndexOf(s.charAt(i))==s.indexOf(s.charAt(i))) return i;
        }
        return -1;
    }
}
