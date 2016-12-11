/**
 * Created by rahilvora on 7/14/16.
 */
public class JumpGameII {
    public static void main(String args[]){
        int[] nums = {3,2,4,2,1,6};
        int[] nums1 = {2,1};
        System.out.print(jump(nums));
    }

    public static  int jump(int[] nums){

        int step = 0;
        int len = nums.length;
        if(len == 1){
            return step;
        }
        int nextIndex = 0;
        for(int i = 0; i < len; i++){
            int jump = nums[nextIndex];
            if(jump >= len){
                return ++step;
            }
            int currentValue = 0;
            for(int j = i + 1; j <= jump; j++){
                if(j < len && currentValue < nums[j] ){
                    currentValue = nums[j];
                    nextIndex = j;
                }
                if(j >= len){
                    return step;
                }
                i = j;
            }
            step++;

        }
        return step;
    }

    public static int jump2(int[] A){
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i=0; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            if( i == e ) {
                sc++;
                e = max;
            }
        }
        return sc;
    }
}
