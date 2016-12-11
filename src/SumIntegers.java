/**
 * Created by rahilvora on 7/23/16.
 */
public class SumIntegers {

    public static void main(String args[]){
        System.out.print(new SumIntegers().getSum(2,3));
    }

    public int getSum(int a, int b) {
        int carry = a&b;
        int sum = a^b;
        boolean flag = false;
        while(carry != 0 || flag == false) {
            flag = true;

            carry = carry << 1;
            int carryNew = carry & sum;
            sum = sum ^ carry;
            carry = carryNew;

        }
        return sum;
    }
}
