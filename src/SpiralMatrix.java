import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahilvora on 12/11/16.
 */
public class SpiralMatrix {
    public static void main(String args[]){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new SpiralMatrix().spiralOrder(matrix);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return list;
        int top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1, left = 0;
        int direction = 0;
        while(top <= bottom && left <= right){
            if(direction == 0){
                for(int i = left; i <= right; i++){
                    list.add(matrix[top][i]);
                }
                top++;
            }
            else if(direction == 1){
                for(int i = top; i <= bottom; i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }
            else if(direction  == 2){
                for(int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else if(direction == 3){
                for(int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return list;
    }
}
