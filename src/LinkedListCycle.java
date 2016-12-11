//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by rahilvora on 9/4/16.
// */
//public class LinkedListCycle {
//    Node head;
//    LinkedListCycle(){
//         head = null;
//    }
//    public static void main(String args[]){
//        LinkedListCycle obj = new LinkedListCycle();
//        obj.addNode(5);
//        Set<Integer> set = new HashSet<>();
//    }
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while(head != null){
//            if(set.add((head)))
//                head = head.next;
//            else
//                return true;
//        }
//        return false;
//    }
//    public void addNode(int n){
//        if(head == null){
//            head = new Node(n);
//        }
//        else{
//            Node temp = head;
//            while(temp.next != null){
//                temp = temp.next;
//            }
//            temp.next = new Node(n);
//        }
//    }
//}
////class Node {
////         int val;
////         Node next;
////         Node(int x) {
////                 val = x;
////                 next = null;
////             }
////     }