import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by rahilvora on 10/15/16.
 */
public class Test {
    public String a(String str){
        char[] arr1 = str.toCharArray();
        char[] arr2 = new char[arr1.length];
        int i = 0, j = arr1.length -1;
        while(i < arr1.length){
            arr2[i] = arr1[j];
            i++;
            j--;
        }
        return new String(arr2);
    }
    public String b(String str1){
        StringBuffer s = new StringBuffer();
        StringBuffer answer = new StringBuffer();
        int i = 0;
        while(i < str1.length()){
            if(str1.charAt(i) != ' '){
                s.append(str1.charAt(i));
            }
            else if(str1.charAt(i) == ' ' && s.length() != 0) {
                answer.append(a(s.toString()));
                answer.append(' ');
                s.replace(0, s.length(), "");
            }
            else{
                answer.append(' ');
            }
            i++;
        }
        if(s.length() != 0) answer.append(a(s.toString()));
        return answer.toString();
    }
    public static void main(String args[]) {
        new Test().b("Secret Message    test");
    }
}
