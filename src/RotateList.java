/**
 * Created by rahilvora on 7/25/16.
 */
public class RotateList {
    ListNode head;
    RotateList(){
        head = null;
    }
    public static void main(String args[]){
        RotateList obj = new RotateList();
        obj.addNode(1);
        obj.addNode(2);
        obj.addNode(3);
        obj.addNode(4);
        obj.addNode(5);
        obj.display();
        obj.rotateRight(obj.head, 2);
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

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode answer = null;
        while(k > 0){
            ListNode temp = head;
            int value = temp.val;
            temp = temp.next;
            while(temp != null){
                int tempvr = temp.val;
                temp.val = value;
                value = tempvr;
                temp = temp.next;
            };
            head.val = value;
            k--;
        }
        return head;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
