import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahilvora on 9/15/16.
 */
public class GenerateParentheses {
    public static void main(String args[]){
        new GenerateParentheses().generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
//    public List<String> generateParenthesis(int n) {
//        ArrayList<String> list = new ArrayList<String>();
//        dfs(list, "", n,n);
//        return list;
//    }
//
//    public void dfs(ArrayList<String> result, String s, int left, int right){
//        if(left > right)
//            return;
//
//        if(left==0&&right==0){
//            result.add(s);
//            return;
//        }
//
//        if(left>0){
//            dfs(result, s+"(", left-1, right);
//        }
//
//        if(right>0){
//            dfs(result, s+")", left, right-1);
//        }
//    }
}
