import java.util.HashSet;
import java.util.Set;

/**
 * Created by rahilvora on 8/17/16.
 */
public class ReverseVowels {
    public static void main(String args[]){
        System.out.print(new ReverseVowels().reverseVowels("leetcode"));
    }
    public String reverseVowels(String s) {
        char[] list =  s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for(int i = 0, j = s.length() -1 ; i < j;){
            if(!set.contains(list[i])){
                i++;
                continue;
            }
            if(!set.contains(list[j])){
                j--;
                continue;
            }
            char temp=list[i];
            list[i]=list[j];
            list[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(list);

    }
}
