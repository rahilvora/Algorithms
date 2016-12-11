import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rahilvora on 11/29/16.
 */
public class MergerKSortedList {
    ListNode head;
    MergerKSortedList(){
        head = null;
    }
    public static void main(String args[]){
        MergerKSortedList obj = new MergerKSortedList();
        MergerKSortedList obj1 = new MergerKSortedList();
        obj.addNode(5);
        obj.addNode(6);
        obj.addNode(8);

        obj1.addNode(0);
        obj1.addNode(10);
        obj1.addNode(11);
        ListNode[] arr = {obj.head, obj1.head};
        new MergerKSortedList().mergeKLists(arr);

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list: lists){
            if(list != null)
                queue.offer(list);
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;

            if(node.next != null){
                queue.offer(node.next);
            }
        }
        return head.next;
    }
}
