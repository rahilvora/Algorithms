import java.util.Stack;

/**
 * Created by rahilvora on 10/19/16.
 */
public class LogestValidParenthesis {
    public static void main(String args[]){
        System.out.print(new LogestValidParenthesis().longestValidParentheses("(()()()"));
    }
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '('){
                stack.pop();
                result = Math.max(result, i - stack.peek());
            }
            else{
                stack.push(i);
            }
        }
        return result;
    }
}
