/**
 * Created by rahilvora on 7/26/16.
 */
public class PowerOfThree {
    public static void main(String args[]){
        System.out.print(new PowerOfThree().isPowerOfThree(1));
    }
    public boolean isPowerOfThree(int n){

        boolean answer = false;
        if(n == 1){
            return true;
        }
        while(n > 1){
            if(n%3 == 0){
                n = n / 3;
                answer = true;
            }
            else{
                answer = false;
                break;
            }
        }
        return answer;
    }
}
