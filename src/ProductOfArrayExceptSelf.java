/**
 * Created by rahilvora on 7/21/16.
 */
public class ProductOfArrayExceptSelf {
    public static void main(String args[]){
        int[] arr = {2,3,4,5,6};
        new ProductOfArrayExceptSelf().productExceptSelf(arr);
    }
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;

        for(int i = 1; i < len; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        int right = 1;
        for(int n = len -1; n >= 0; n--){
            res[n] *= right;
            right *= nums[n];
        }
        for (int x:
             res) {
            System.out.print(x+ " ");
        }
        return res;
    }
}
