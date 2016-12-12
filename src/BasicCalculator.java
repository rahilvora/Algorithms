import java.util.Stack;

/**
 * Created by rahilvora on 9/21/16.
 */
public class BasicCalculator {
    public static void main(String args[]){
        System.out.print(new BasicCalculator().calculate1("3*2+2"));
    }
    public static int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }

    public int calculate1(String s) {
        if(s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num *=10 + c - '0';
            }
            if(!Character.isDigit(c) && ' '!= c || i == s.length() - 1){

                switch(sign){
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
                sign = c;
                num = 0;

            }
        }

        num = 0;

        while(!stack.empty()){
            num += stack.pop();
        }
        return num;

    }
}
