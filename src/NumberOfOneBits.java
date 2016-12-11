/**
 * Created by rahilvora on 7/26/16.
 * >> "signed right shift operator"
 * >>> "Unsigned right shift operator"
 * Theory
 * The operator ‘>>’ uses the sign bit (left most bit) to fill the trailing positions after shift. If the number is negative,
 * then 1 is used as a filler and if the number is positive, then 0 is used as a filler. For example, if binary representation
 *
 * In Java, the operator ‘>>>’ is unsigned right shift operator. It always fills 0 irrespective of the sign of the number.
 *
 */
public class NumberOfOneBits {
    public static void main(String args[]){
        System.out.print(new NumberOfOneBits().numberOfOne(11));
    }
    public int numberOfOne(int n){
        int count = 0;
        while(n != 0){
            count += n&1;
            n = n >>> 1;
        }
        return count;
    }
}
