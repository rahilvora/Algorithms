/**
 * Created by rahilvora on 3/8/17.
 */
public class SpiralMatrixII {
    public static void main(String args[]){
        new SpiralMatrixII().generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int direction = 0;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int value = 1;
        int[][] answer = new int[n][n];
        while(top <= bottom && left <= right){
            //Left to right
            if(direction == 0){
                for(int i = left; i<=right; i++){
                    answer[top][i] = value++;
                }
                top++;
            }
            //top to bottom
            else if(direction == 1){
                for(int i = top; i<= bottom; i++){
                    answer[i][right] = value++;
                }
                right--;
            }
            // left to right
            else if(direction == 2){
                for(int i = right; i >= left; i--){
                    answer[bottom][i] = value++;
                }
                bottom--;
            }
            // bottom to top
            else if(direction == 3){
                for(int i = bottom; i >= top; i--){
                    answer[i][left] = value++;
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return answer;
    }
}
