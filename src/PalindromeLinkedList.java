import java.util.ArrayList;

/**
 * Created by rahilvora on 9/6/16.
 */
public class PalindromeLinkedList {
    public static void main(String args[]){
        System.out.print(new PalindromeLinkedList().isPalindrome(null));
    }
    //Using an extra space
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        int start = 0, end = arr.size() - 1;
        while(start < end){
            if(arr.get(start) != arr.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //Without using an extra space O(1)

    public boolean isPalindrome1(ListNode head){
        if(head != null) {
            ListNode p1 = head, p2 = head;
            ListNode p3 = p1.next;
            ListNode pre = p1;

            while (p2.next != null && p2.next.next != null) {
                p2 = p2.next.next;
                pre = p1;
                p1 = p3;
                p3 = p3.next;
                p1.next = pre;
            }
            // If even number of nodes we need to move p1 by one
            if (p2.next == null) {
                p1 = p1.next;
            }
            while (p3 != null) {
                if (p1.val != p3.val) {
                    return false;
                }
                p1 = p1.next;
                p3 = p3.next;
            }
        }
        return true;
    }
}
