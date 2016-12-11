/**
 * Created by rahilvora on 9/5/16.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        if(head == null || head.next == null)
            return null;
        do{
            if(fast == null || fast.next == null){
                return null;
            }
            else{
                slow = slow.next;
                fast = fast.next.next;
            }
        }while(slow != fast);
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
