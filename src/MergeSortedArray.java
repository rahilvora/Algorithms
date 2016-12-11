import java.util.Arrays;

/**
 * Created by rahilvora on 7/18/16.
 */
public class MergeSortedArray {
    public static void main(String args[]){
        int[] nums1 = {5,6,7,0,0,0};
        int[] nums2 = {1,2,3};
        new MergeSortedArray().merge(nums1, nums1.length, nums2, nums2.length);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int startIndex = nums1.length - nums2.length;
        int lastIndex = startIndex + nums2.length;
        int count = 0;
        for(int i = startIndex; i < lastIndex; i++){
            nums1[i] = nums2[count];
            count++;
        }
        Arrays.sort(nums1);
    }
}
