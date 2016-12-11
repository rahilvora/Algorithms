import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rahilvora on 9/4/16.
 */
public class MyStackUsingQueues {
    Queue queue1 = new LinkedList();
    Queue queue2 = new LinkedList();
    public static void main(String args[]){
        MyStackUsingQueues obj = new MyStackUsingQueues();
        obj.push(5);
        obj.push(3);
        obj.push(2);
        obj.pop();
    }
    // Push element x onto stack.
    public void push(int x) {
        if(queue1.isEmpty()){
            queue1.add(x);
        }
        else{
            while(!queue1.isEmpty()){
                queue2.add(queue1.remove());
            }
            queue1.add(x);
            while (!queue2.isEmpty()){
                queue1.add(queue2.remove());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!queue1.isEmpty()){
            queue1.remove();
        }
    }

    // Get the top element.
    public int top() {
        return (int) queue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}
