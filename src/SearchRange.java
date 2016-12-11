/**
 * Created by rahilvora on 7/19/16.
 * For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchRange {
    public static void main(String args[]){
        int[] arr = {5, 7, 7, 8, 8, 10};
        int[] arr1 = {2,2};
        new SearchRange().searchRange(arr1, 3);
    }
    public int[] searchRange(int[] nums, int target){
        int[] answer = {-1,-1};
        int start = 0, end = nums.length -1;
        int mid = (start + end)/2;

        if(nums[mid] > target){
            end = mid -1;
            while(start <= end){
                if(nums[start] == nums[end]){
                    answer[0] = start;
                    answer[1] = end;
                    break;
                }
                //start++;
                end--;
            }
        }
        else if( nums[mid] < target ){
            start = mid + 1;
            while(start <= end){
                if(nums[start] == nums[end]){
                    answer[0] = start;
                    answer[1] = end;
                    break;
                }
                //start++;
                end--;
            }
        }
        else{
            int index = mid;
            int index2 = mid;
            int s = mid, e = mid;
            while(nums[index] != target){
                s = index;
                index--;
            }
            while(nums[index2] != target){
                e = index2;
                index++;
            }
            answer[0] = s;
            answer[1] = e;

        }
        return answer;
    }
}
