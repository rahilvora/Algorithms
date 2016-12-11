/**
 * Created by rahilvora on 9/26/16.
 */
public class NextSmallestNextLargest {
    public static void main(String args[]){
        int num = 3;
        int temp = num >> 1;
        System.out.println("Next Smallest Number is " + (num >> 1));
        System.out.println("Next Largest Number is " + (num << 1));
    }
}
