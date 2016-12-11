/**
 * Created by rahilvora on 8/31/16.
 */
public class ReverseInteger {
    public static void main(String args[]){
        System.out.print(new ReverseInteger().reverse(1534236469));
    }
    public int reverse(int x) {
        if(x > Integer.MAX_VALUE)
            return 0;
        boolean flag = false;
        if(x < 0){
            flag = true;
            x = Math.abs(x);
        }
        int sum = 0;
        while(x > 0){
            sum = sum * 10 + x % 10;
            x /=10;
            if(sum*10 > Integer.MAX_VALUE) {
                return 0;
            }
        }
        if(flag){
            return sum - sum*2;
        }
        return sum;
    }
}
