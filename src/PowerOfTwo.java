/**
 * Created by rahilvora on 7/26/16.
 *
 */
public class PowerOfTwo {
    public static void main(String args[]){
        System.out.print(new PowerOfTwo().isPowerOfTwo(512));
        System.out.print(new PowerOfTwo().isPowerOfTwoII(1024));
    }

    //Simple approach
    public boolean isPowerOfTwo(int n) {
        boolean answer = false;
        if(n == 1){
            return true;
        }
        while(n > 1){
            if(n%2 == 0){
                n = n / 2;
                answer = true;
            }
            else{
                answer = false;
                break;
            }
        }
        return answer;
        }

    //Bit Manipulation Approach
    /*
    * If we subtract a power of 2 numbers by 1 then all unset bits after the only set bit become set; and
    * the set bit become unset. For example for 4 ( 100) and 16(10000), we get following after subtracting 1
      3 –> 011
      15 –> 01111
    So, if a number n is a power of 2 then bitwise & of n and n-1 will be zero. We can say n is a power of 2 or not
    based on value of n&(n-1). The expression n&(n-1) will not work when n is 0. To handle this case also, our expression
    will become n& (!n&(n-1)) (thanks to Mohammad for adding this case).
    Below is the implementation of this method.*/

    public boolean isPowerOfTwoII(int n){
        if((n&(n-1)) == 0){
            return true;
        }
        else{
            return false;
        }
    }
}



