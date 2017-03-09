/**
 * Created by rahilvora on 2/20/17.
 */
public class ValidPerfectSquare {
    public static void main(String args[]){
        System.out.print(new ValidPerfectSquare().isPerfectSquare(808201));
    }
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = low + (high - low)/2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}
