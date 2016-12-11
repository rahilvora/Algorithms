import java.util.Arrays;

/**
 * Created by rahilvora on 9/22/16.
 */
public class PythogoreanTriplet {
    public static void main(String args[]){
        int[] nums = {3, 1, 4, 6, 5};
        System.out.print(new PythogoreanTriplet().isPythogoreanTriplet(nums));
    }
    public boolean isPythogoreanTriplet(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i ++){
            arr[i] = arr[i]*arr[i];
        }
        Arrays.sort(arr);
        for(int j= len-1; j >=2; j--){
            int l = 0;
            int r = j -1;
            while(l < r){
                if(arr[l] + arr[r] == arr[j]){
                    return true;
                }
                if(arr[l] + arr[r] < arr[j]){
                    l++;
                }else{
                    r--;
                }

            }
        }
        return false;
    }
}
