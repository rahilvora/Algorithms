import java.util.Stack;

/**
 * Created by rahilvora on 3/9/17.
 */
public class SortStack {
    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        stack.add(30);
        stack.add(-5);
        stack.add(18);
        stack.add(14);
        stack.add(-3);
    }

    public void sortStack(Stack<Integer> stack){
        if(!stack.empty()){
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack, temp);
        }
    }

    public void sortedInsert(Stack<Integer> stack, int element){
        if(stack.empty()){
            stack.push(element);
        }
        else if(element > stack.peek()){
            stack.push(element);
        }
        else{
            int temp = stack.pop();
            sortedInsert(stack,element);
            stack.push(temp);
        }
    }


}
