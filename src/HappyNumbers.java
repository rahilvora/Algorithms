import java.util.HashSet;
import java.util.Set;

/**
 * Created by rahilvora on 9/2/16.
 */
public class HappyNumbers {
    public static void main(String args[]){
        System.out.print(new HappyNumbers().isHappy2(42));
    }
    // Fast and Slow pointer approach
    public boolean isHappy(int num) {
        int slow =num, fast = num;
        do{
            slow = digitSquare(slow);
            fast = digitSquare(fast);
            fast = digitSquare(fast);
            System.out.println("Slow " + slow + " Fast " + fast);
        }while (slow != fast);
        if(slow == 1)
            return true;
        return false;
    }

    public int digitSquare(int n){
        int temp = 0;
        while(n > 0){
            int tmp = n % 10;
            temp = temp + tmp*tmp;
            n = n/10;
        }
        return temp;
    }

    //Using SETs
    public boolean isHappy2(int num){
        Set<Integer> set = new HashSet<>();
        while(set.add(num)){
            int sumOfSquares = 0;
            while(num > 0){
                int temp = num % 10;
                sumOfSquares = sumOfSquares + temp * temp;
                num = num / 10;
            }
            if(sumOfSquares == 1) return true;
            num = sumOfSquares;
        }
        return false;
    }
}
