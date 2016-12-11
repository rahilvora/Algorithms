import java.util.List;

/**
 * Created by rahilvora on 12/3/16.
 */
public class SortListToBST {
    ListNode head;
    SortListToBST(){
        head = null;
    }
    public static void main(String[] args){
        SortListToBST obj = new SortListToBST();
        obj.addNode(1);
        obj.addNode(2);
        obj.addNode(3);
        obj.addNode(4);
        obj.addNode(5);
        obj.addNode(6);
        obj.createTree(obj.head);
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
    public TreeNode createTree(ListNode head){
        if(head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast.next != null){
            fast = fast.next;
            if(fast.next == null) break;
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if(prev != null)
            prev.next = null;
        else
            head = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = createTree(head);
        root.right = createTree(slow.next);
        return root;
    }
}
