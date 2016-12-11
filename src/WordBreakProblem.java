import java.util.HashSet;

/**
 * Created by rahilvora on 7/26/16.
 */
public class WordBreakProblem {

    public static void main(String args[]){
        HashSet<String> dict = new HashSet<>();
        dict.add("I");
        dict.add("have");
        dict.add("Rahil");
        dict.add("Vora");
        dict.add("am");
        dict.add("Master");
        dict.add("degree");
        new WordBreakProblem().workbreak("Mastersdegree", dict);
    }
    public void workbreak(String s, HashSet<String> dict){
        if(find(s, dict, "")){
            //System.out.print("True");
        }
        else {
            System.out.print("False");
        }
    }

    public boolean find(String s, HashSet<String> dict, String answer ){
        if(s.length() == 0){
            System.out.print(answer + " ");
            return true;
        }
        else{
            int index = 0;
            String word = "";
            while(index < s.length()){
                word += s.charAt(index);
                if(dict.contains(word)){
                    if(find(s.substring(index+1), dict, answer + word + " ")){
                        return true;
                    }
                    else{
                        index++;
                    }
                }
                else{
                    index++;
                }
            }
            return false;
        }
    }
}
