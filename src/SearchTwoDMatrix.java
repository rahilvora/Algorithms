/**
 * Created by rahilvora on 2/23/17.
 */
public class SearchTwoDMatrix {
    public static void main(String args[]){
        int[][] arr = {
                {1,4,7,11,15},
                {2, 5, 8, 12,19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.print(new SearchTwoDMatrix().searchMatrix(arr, 5));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int col = matrix[0].length - 1;
        int row = 0;
        while(row < matrix.length && col >=0){
            int val = matrix[row][col];
            if(target == val){
                return true;
            }
            else if(target > val){
                row++;
            }
            else if(target < val){
                col--;
            }
        }
        return false;
    }
}
