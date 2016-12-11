/**
 * Created by rahilvora on 7/28/16.
 */
public class UglyNumber {
    public static void main(String args[]){
        System.out.print(new UglyNumber().isUgly(15));
    }
    public boolean isUgly(int num) {
        boolean ans = true;
        if(num == 1){
            return ans;
        }
        while(num > 1){
            if(num % 2 == 0){
                ans = true;
                num = num / 2;
            }
            else if(num % 3 == 0){
                ans = true;
                num = num /3;
            }
            else if(num % 5 == 0){
                ans = true;
                num = num / 5;
            }
            else {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
