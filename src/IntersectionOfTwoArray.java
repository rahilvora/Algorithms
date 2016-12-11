import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rahilvora on 7/25/16.
 */
public class IntersectionOfTwoArray {
    public static void main(String args[]){
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        new IntersectionOfTwoArray().intersection(arr1, arr2);
    }

    // O(n)
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i = 0;i < nums1.length; i++){
            if(!set1.contains(nums1[i])){
                set1.add(nums1[i]);
            }
        }

        for(int j = 0; j < nums2.length; j++){
            if(set1.contains(nums2[j])){
                set2.add(nums2[j]);
            }
        }
        int[] answer = new int[set2.size()];
        int count = 0;

        for (int x:
             set2) {
            answer[count] = x;
            count++;
        }

        return answer;

    }

    //O(nlogN)

    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
}
