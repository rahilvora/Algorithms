/**
 * Created by rahilvora on 1/18/17.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

    public static void main(String args[]){
        System.out.print(new IsSubsequence().isSubsequence("aa","a"));
    }

}
