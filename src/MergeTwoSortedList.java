/**
 * Created by rahilvora on 9/7/16.
 */
public class MergeTwoSortedList {
    ListNode head;
    MergeTwoSortedList(){
        head = null;
    }
    public static void main(String args[]){
        MergeTwoSortedList obj1 = new MergeTwoSortedList();
        MergeTwoSortedList obj2 = new MergeTwoSortedList();
        obj1.addNode(1);
        obj1.addNode(3);
        obj1.addNode(5);
        obj1.addNode(7);
        obj2.addNode(2);
        obj2.addNode(4);
        obj2.addNode(6);
        obj2.addNode(8);
        MergeTwoSortedList.mergeTwoLists(obj1.head, obj2.head);
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(1);
        ListNode dummy = newHead;

        while(l1 != null && l2 != null){
            if(l1.val >= l2.val) {
                newHead.next = l2;
                l2 = l2.next;
            }
            else {
                newHead.next = l1;
                l1 = l1.next;
            }
            newHead = newHead.next;
        }
        // Append the remain of the list
        newHead.next = (l1 != null) ? l1:l2;
        return dummy.next;
    }
}
