/**
 * Created by rahilvora on 9/8/16.
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddNumsOfTwoLinkedList {
    ListNode head;
    AddNumsOfTwoLinkedList(){
        head = null;
    }
    public static void main(String args[]){
        AddNumsOfTwoLinkedList obj = new AddNumsOfTwoLinkedList();
        AddNumsOfTwoLinkedList obj1 = new AddNumsOfTwoLinkedList();
        obj.addNode(1);
        obj1.addNode(9);
        obj1.addNode(9);
        AddNumsOfTwoLinkedList.addTwoNumber3(obj.head, obj1.head );
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

    public static ListNode addTwoNumber3(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(1);
        ListNode dummy = ans;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val = 0;
            if(l1 == null && l2 != null){
                val = val + l2.val + carry;
                if(val > 9){
                    carry = val /10;
                    val = val % 10;
                }
                else{
                    carry = 0;
                }
            }
            else if(l2 == null && l1 != null){
                val = val + l1.val + carry;
                if(val > 9){
                    carry = val /10;
                    val = val % 10;
                }
                else{
                    carry = 0;
                }
            }
            else if(l1 != null && l2 != null){
                val = l1.val + l2.val + carry;
                if(val > 9){
                    carry = val /10;
                    val = val % 10;
                }
                else{
                    carry = 0;
                }
            }
            else if( carry != 0){
                val = carry;
                carry = 0;
            }

            dummy.next = new ListNode(val);
            if( l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        return ans.next;
    }

}
