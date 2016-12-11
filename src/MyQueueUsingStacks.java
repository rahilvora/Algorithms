import java.util.Stack;

/**
 * Created by rahilvora on 7/28/16.
 */
public class MyQueueUsingStacks {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();
    public static void main(String agrs[]){
        MyQueueUsingStacks obj = new MyQueueUsingStacks();
        obj.push(5);
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.push(1);
        obj.peek();
        obj.pop();
    }
    public void push(int x) {
        if(stack1.empty()){
            stack1.add(x);
        }
        else{
            while(!stack1.empty()){
                stack2.add(stack1.pop());
            }
            stack1.add(x);
            while (!stack2.empty()){
                stack1.add(stack2.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        System.out.print(stack1.pop());
    }

    // Get the front element.
    public int peek() {
        System.out.print(stack1.peek());
        return  (int) stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty();
    }
}
