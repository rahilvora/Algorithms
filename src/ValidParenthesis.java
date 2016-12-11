import java.util.Stack;

/**
 * Created by rahilvora on 7/27/16.
 */
public class ValidParenthesis {
    public static void main(String args[]){
        System.out.print(new ValidParenthesis().isValid(""));
    }

    //Naive Solution1
    public boolean isValid(String s) {
        Stack stack = new Stack();
        int len = s.length();
        boolean ans = false;
        for(int i = 0; i < len; i++){
            ans = false;
            char ch = s.charAt(i);
            if(stack.empty()){
                stack.add(ch);
            }
            else{
                char c = (char) stack.peek();
                if(c == '('){
                    if(ch == ')'){
                        ans = true;
                        stack.pop();
                    }
                    else if(ch == '}' || ch == ']'){
                        ans = false;
                        break;
                    }
                    else stack.add(ch);


                }
                else if(c == '{'){
                    if(ch == '}'){
                        ans = true;
                        stack.pop();
                    }
                    else if(ch == ']' || ch == ')'){
                        ans = false;
                        break;
                    }
                    else stack.add(ch);
                }
                else if(c == '['){
                    if(ch == ']'){
                        ans = true;
                        stack.pop();
                    }
                    else if(ch == '}' || ch == ')'){
                        ans = false;
                        break;
                    }
                    else
                        stack.add(ch);
                }
            }
        }
        if(stack.empty()){
            ans = true;
        }
        else{
            ans = false;
        }
        return ans;
    }
    //Same approach but less lines of code and concise solution
    public boolean isValidTwo(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
                // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }
}
