/**
 * Created by rahilvora on 6/22/16.
 */
public class DoublyLinkedList {
    Node head;
    DoublyLinkedList(){
        head = null;
    }
    public static void main(String[] args){
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.addEnd(5);
        obj.addEnd(6);
        obj.addEnd(7);
        obj.addEnd(8);
        obj.addStart(9);
        obj.addStart(10);
        obj.display();
        obj.deleteEnd();
        obj.display();

    }
    public void addStart(int a){
        if(head == null){
            head =  new Node(a,null,null);
        }
        else{
            Node newNode = new Node(a, null, head);
            head.prev = newNode;
            head = newNode;
        }
    }
    public void addEnd(int a){
        if(head == null){
            head = new Node(a, null, null);
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            Node newNode = new Node(a, temp, null);
            temp.next = newNode;
        }
    }
    public void deleteStart(){
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        else{
            System.out.println(head.key +" Deleted");
            head = head.next;
        }
    }
    public void deleteEnd(){
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        else{
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            System.out.print(temp.key +" Deleted");
            temp.next = null;
        }

    }
    public void display(){
        if(head == null) {
            System.out.println("LinkedList is empty");
        }
        else {
            Node temp =  head;
            while(temp.next != null){
                System.out.println(temp.key + " ");
                temp = temp.next;
            }
            System.out.println(temp.key + " ");
        }
    }
}
class Node{
    int key;
    Node prev;
    Node next;
    Node(){
        prev = null;
        next = null;
        key = 0;
    }
    Node(int key, Node prev, Node next){
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}