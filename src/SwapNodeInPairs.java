/**
 * Created by rahilvora on 9/8/16.
 */
public class SwapNodeInPairs {
    ListNode head;
    SwapNodeInPairs(){
        head = null;
    }
    public static void main(String args[]){
        SwapNodeInPairs obj = new SwapNodeInPairs();
        obj.addNode(1);
        obj.addNode(2);
        obj.addNode(3);
        obj.addNode(4);
        obj.swapPairs(obj.head);
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
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        ListNode curr = newHead;
        while(curr.next != null && curr.next.next != null){
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        return newHead.next;
    }
}
