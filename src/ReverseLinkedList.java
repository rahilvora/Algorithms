import java.util.List;

/**
 * Created by rahilvora on 7/27/16.
 */
public class ReverseLinkedList {
    ListNode head;
    ReverseLinkedList(){
        head = null;
    }
    public static void main(String args[]){
        ReverseLinkedList obj = new ReverseLinkedList();
        obj.addNode(1);
        obj.addNode(1);
        obj.addNode(1);
        obj.addNode(1);
        obj.addNode(1);
        obj.deleteDuplicates(obj.head);
        //obj.deleteNode(new ListNode(5));
        //obj.head = obj.reverseList(obj.head);
        obj.display();
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
    public void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    public ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    public void deleteNode(ListNode node) {
        ListNode temp = head;
        ListNode slowTemp = temp;
        while(temp.next != null){
            if(head.val == node.val){
                head = head.next;
            }
            else if(temp.val == node.val && temp.next == null){
                temp = null;
            }
            else if(temp.val == node.val && temp.next != null){
                slowTemp.next = temp.next;
            }
            slowTemp = temp;
            temp = temp.next;
        }
        if(temp.val == node.val){
            slowTemp.next = temp.next;
        }
        display();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
                else if(temp.val != temp.next.val)
            temp = temp.next;
        }
        return head;
    }

}
