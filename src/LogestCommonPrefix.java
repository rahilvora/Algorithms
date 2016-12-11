/**
 * Created by rahilvora on 9/19/16.
 */
public class LogestCommonPrefix {
    public static void main(String args[]){
        String[] strs = {"aa","a"};
        //System.out.print("He");
        System.out.print(new LogestCommonPrefix().longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].equals("")) return "";
        if (strs.length == 1) return strs[0];
        for(int j = 0; j < strs[0].length(); j++) {
            StringBuffer prefix = new StringBuffer(strs[0].substring(0, j + 1));
            for (int i=1; i< strs.length; i++) {
                if (strs[i].equals("")) return "";
                if (strs[i].length() < prefix.length() || !(strs[i].substring(0, j + 1)).equals(prefix.toString()))
                { return prefix.substring(0, prefix.length() - 1);}
            }
            if (prefix.length() == strs[0].length()) return prefix.toString();
        }
        return "";
    }
}
