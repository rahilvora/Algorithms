import java.util.Stack;

/**
 * Created by rahilvora on 2/11/17.
 */
public class SimplifyPath {
    public static void main(String args[]){
        System.out.print(new SimplifyPath().simplifyPath("/."));
    }
    public String simplifyPath(String path) {
        if(path.length() == 0) return "";
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == '.' && stack.size() > 1){
                while(!stack.empty()){
                    stack.pop();
                }
            }
            else if(!stack.empty() && stack.peek() == '/' && path.charAt(i) =='/'){
                stack.pop();
            }
            if(path.charAt(i) != '.'){
                stack.push(path.charAt(i));
            }
        }
        if(stack.peek() == '/' && stack.size() > 1) stack.pop();
        while(!stack.empty()){
            str.insert(0, stack.pop());
        }
        return str.toString();
    }
}
