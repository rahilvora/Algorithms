/**
 * Created by rahilvora on 3/19/17.
 */
public class TrappingRainWater {
    public static void main(String args[]){

    }
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, maxleft = 0 , maxright = 0, result = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left]>=maxleft) maxleft = height[left];
                else result += maxleft - height[left];
                left++;
            }
            else{
                if(height[right]>=maxright) maxright = height[right];
                else result += maxright - height[right];
                right--;
            }
        }
        return result;
    }
}
