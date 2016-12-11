/**
 * Created by rahilvora on 7/19/16.
 */
public class FIndPeakElement {
    public static void main(String args[]){
    int[] nums =  {3,2,1};
    int[] nums1 = {1,2,3,1};
    int[] nums2 = {1,2,1};
        System.out.print(new FIndPeakElement().findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        int index = 0;
        int len = nums.length;
        for( int i = 1; i < len ; i++ ){
            if(i + 1 < len ){
                if(nums[i] > nums[i+1] && nums[i] > nums[i -1]){
                    index = i;
                    break;
                }
            }
            else{
                if(i == len -1){
                    if(nums[i] > nums[i -1]){
                        index = i;
                        break;
                    }
                }

                else if(i == 1){
                    if(nums[i-1] > nums[i]){
                        index = i -1;
                        break;
                    }
                }
            }
        }
        return index;
    }
}
