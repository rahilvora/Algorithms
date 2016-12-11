import java.util.Scanner;

/**
 * Created by rahilvora on 6/22/16.
 * Simple Stack implementation using array
 */
public class Stacks {

    static int[] stackarray = new int[5];
    static int length = stackarray.length;
    static int head = 0;

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
        if(head == length){
            System.out.println("Stack Overflows");
        }
        else{
            stackarray[head] = a;
            head++;
        }
    }

    public static void pop(){
        if(head == 0){
            System.out.println("Stack underflows");
        }
        else{
            System.out.println(stackarray[head] + " Poped");
            head--;
        }
    }

    public static void peek(){
        if(head == 0){
            System.out.println("Stack underflows");
        }
        else{
            System.out.println(stackarray[head] + " at Peek");
        }
    }

    public static void display(){
        if(head == 0){
            System.out.println("Stack underflows");
        }
        else{
            for(int i = 0; i< head; i++){
                System.out.println(stackarray[i] +" ");
            }
        }
    }
}
