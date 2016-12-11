/**
 * Created by rahilvora on 10/21/16.
 */
public class SortColors {
    public static void main(String args[]){
        int[] nums = {1,2,0,2,1,0};
        new SortColors().sortColors1(nums);
    }
    //O(n^2) solution
    public void sortColors(int[] nums) {
        int slow = 0;
        for(int i = slow; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
    //O(N) Solution1
    public void sortColors1(int[] A) {
        if(A==null || A.length<2) return;
        int low = 0;
        int high = A.length-1;
        for(int i = low; i<=high;) {
            if(A[i]==0) {
                // swap A[i] and A[low] and i,low both ++
                int temp = A[i];
                A[i] = A[low];
                A[low]=temp;
                i++;low++;
            }else if(A[i]==2) {
                //swap A[i] and A[high] and high--;
                int temp = A[i];
                A[i] = A[high];
                A[high]=temp;
                high--;
            }else {
                i++;
            }
        }
    }
}
