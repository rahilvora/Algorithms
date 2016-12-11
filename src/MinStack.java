import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rahilvora on 7/28/16.
 */
public class MinStack {
    Stack stack;
    ArrayList<Integer> arr;
    public static void main(String args[]){
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        System.out.print(obj.getMin());
        System.out.print(obj.top());
        obj.pop();
        System.out.print(obj.getMin());
    }
    public MinStack() {
        stack = new Stack();
        arr = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        arr.add(x);
    }

    public void pop() {
        int a =0;
        if(!arr.isEmpty()){
            arr.remove((int) stack.pop());
        }
       // stack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        arr.sort((o1,o2) -> o1.compareTo(o2));
        return arr.get(0);
    }
}
