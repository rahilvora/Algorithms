import java.util.Stack;

/**
 * Created by rahilvora on 11/25/16.
 */
public class BasicCalculatorII {
    public static void main(String args[]){
        System.out.println(new BasicCalculatorII().calculate(" 3 * 2 + 2"));
    }
    public int calculate(String s) {
        if(s.isEmpty()) return 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(Character.isDigit(character)){
                num = num * 10 + character - '0';
            }
            if(!Character.isDigit(character) && ' '!=character || i == s.length() - 1){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = character;
                num = 0;
            }
        }
        num = 0;
        for (int i :stack){
            num += i;
        }
        return num;
    }
}
