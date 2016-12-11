/**
 * Created by rahilvora on 8/5/16.
 */
public class SearchInAMatrix {
    public static void main(String args[]){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.print(new SearchInAMatrix().searchMatrix1(matrix, 0));
    }
    //Naive Approach
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] <= target && matrix[i][matrix[0].length -1] >= target)
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == target){
                    ans = true;
                    return ans;
                }
            }
        }
        return ans;
    }

    //Binary Search Approach
    public boolean searchMatrix1(int[][] matrix, int target) {

        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }
}
