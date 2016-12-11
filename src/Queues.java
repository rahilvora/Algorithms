import java.util.Scanner;

/**
 * Created by rahilvora on 6/22/16.
 * Queue implementation using simple array
 */
public class Queues {
    static int[] queuearray = new int[5];
    static int length = queuearray.length;
    static int head = -1;
    static int tail = -1;

    public static void main(String[] args){
        boolean choice = true;
        while(choice){
            System.out.println("Enter the operation to be performed \n 1. Push \n 2. Pop \n 3. Display \n 4. Exit");
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();
            switch(option){
                case 1:{
                    System.out.println("Enter the value to be pushed");
                    push(in.nextInt());
                    break;
                }
                case 2:{
                    pop();
                    break;
                }
                case 3:{
                    display();
                    break;
                }
                case 4:{
                    choice = false;
                    break;
                }

            }
        }
    }

    public static void push(int a){
        if(head == 0 && tail == length - 1){
            System.out.println("Queue Overflows");
        }
        else if(head == -1 && tail == -1){
            head++;
            tail++;
            queuearray[tail] = a;
        }
        else if(tail == head){
            queuearray[tail + 1] = a;
            tail++;
        }
        else if(tail == length - 1 && head != 0){
            tail = 0;
            queuearray[tail] = a;
        }
        else if(tail + 1 == head){
            System.out.println("Queue Overflows");
        }
        else if(tail < head ){
            queuearray[tail + 1] = a;
            tail++;
        }
        else if(tail<length - 1  && tail>=head){
            tail++;
            queuearray[tail] = a;
        }
    }

    public static void pop(){
        if(tail == -1 && head == -1){
            System.out.println("Queue underflows");
        }
        else if(head == length && tail < head){
            System.out.println(queuearray[head] + " Poped");
            head = 0;
        }
        else if(head == tail){
            System.out.println(queuearray[head] + " Poped");
            head = -1;
            tail = -1;
        }
        else{
            System.out.println(queuearray[head] + " Poped");
            head++;
        }
    }


    public static void display(){
        if(head < tail){
            for(int i = head; i <= tail; i++){
                System.out.print(queuearray[i] + " ");
            }
        }
        else{
            for(int i = head; i < length; i++){
                System.out.print(queuearray[i] + " ");
            }
            for( int i = 0; i<=tail; i++){
                System.out.print(queuearray[i] +" ");
            }
        }
    }
}
