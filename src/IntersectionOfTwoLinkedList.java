import java.util.HashSet;
import java.util.Set;

/**
 * Created by rahilvora on 9/7/16.
 */
public class IntersectionOfTwoLinkedList {
    // With use of an extra memory
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA != null && headB != null){
            Set<ListNode> set = new HashSet<>();
            while(headA != null){
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null){
                if(!set.add(headB)){
                    return headB;
                }
                headB = headB.next;
            }
        }
        return null;
    }

    //Without using extra memory
    public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

}
