/**
 * Created by rahilvora on 8/31/16.
 */
public class StrStr {
    public static void main(String args[]){
        System.out.print(new StrStr().strStr("mississippi","issipi"));
    }
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        else if(haystack.length() < needle.length()){
            return -1;
        }
        int m, count;
        for(int i = 0; i < haystack.length(); i++){
            count = 0;
            m = i;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(m) != needle.charAt(j)){
                    break;
                }
                count++;
                m++;
                if(m >= haystack.length()){
                    break;
                }
            }
            if(count == needle.length()){
                return m - count;
            }
        }
        return -1;
    }
}
