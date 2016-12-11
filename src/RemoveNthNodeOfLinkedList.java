import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by rahilvora on 9/6/16.
 */
public class RemoveNthNodeOfLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(9527);
        headNode.next = head;
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;
        while(fastNode.next != null){
            if(n <= 0){
                slowNode = slowNode.next;
            } else {
                n--;
            }
            fastNode = fastNode.next;
        }
        if(slowNode.next != null)
            slowNode.next = slowNode.next.next;
        return headNode.next;
    }
}
