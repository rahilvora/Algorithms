/**
 * Created by rahilvora on 7/20/16.
 */
public class WIggleSequence {
    public static void main(String args[]){
        int[] arr = {};
        System.out.print(new WIggleSequence().wiggleMaxLength(arr));
    }
    public int wiggleMaxLength(int[] nums){

        int count = 0;
        int finall = 0;
        int pos = 0;
        int neg = 0;
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        if(nums.length == 2){
            return 2;
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] > 0){
                pos++;
                count++;
                if(pos > 1){
                    pos--;
                    count = 0;
                }
            }
            if(nums[i] - nums[i-1] < 0){
                neg++;
                count++;
                if(neg > 1){
                    neg--;
                    count = 0;
                }
            }
            if(pos == 1 && neg == 1){
                finall += count;
                count = 0;
                pos = neg = 0;
            }
            else if((pos == 1 || neg == 1) && i == nums.length -1 ){
                finall +=count;
                count = 0;
                pos = neg = 0;
            }
        }
        return finall + 1;
    }
}
