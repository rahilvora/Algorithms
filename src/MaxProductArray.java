import java.util.ArrayList;

/**
 * Created by rahilvora on 9/17/16.
 */
public class MaxProductArray {
    public static void main(String args[]){
        int[] arr = {3,-1,4};
        //arr.clear();
        System.out.print(new MaxProductArray().maxProduct(arr));
    }
    public int maxProduct(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        int maxherepre = A[0];
        int minherepre = A[0];
        int maxsofar = A[0];
        int maxhere, minhere;

        for (int i = 1; i < A.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }
}
