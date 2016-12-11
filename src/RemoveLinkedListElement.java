/**
 * Created by rahilvora on 9/7/16.
 */
public class RemoveLinkedListElement {
    ListNode head;
    RemoveLinkedListElement(){
        head = null;
    }
    public static void main(String args[]){
        RemoveLinkedListElement obj = new RemoveLinkedListElement();
        obj.addNode(1);
        obj.removeElements(obj.head, 1);
    }
    public void addNode(int n){
        if(head == null){
            head = new ListNode(n);
        }
        else{
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListNode(n);
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        // Initially remove all the node at the start of the list who's value is equal to required value
        while(head != null && head.val == val){
            head = head.next;
        }
        // traverse entire list to remove remaining element with same value
        ListNode temp = head;
        while(temp != null){
            if(temp.val == val){
                temp = temp.next;
            }
            else if(temp.next != null && temp.next.val == val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }

    // Little easy and optimal solution
    public ListNode removeElementsII(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
