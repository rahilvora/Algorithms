/**
 * Created by rahilvora on 10/20/16.
 */
public class UniquePathsDP {
    public static void main(String args[]){
        System.out.print(new UniquePathsDP().uniquePaths(3,7));
    }
    /*
    *
    *   for 3*7 matrix
    *   1   1   1   1   1   1   1
    *   1   2   3   4   5   6   7
    *   1   3   6   10  15  21  28
    *
    *   Answer is 28 ways
    * */
    public int uniquePaths(int m, int n) {
        //Define an array of size mxn
        int[][] arr = new int[m][n];
        //Set first Column of all rows to One
        for(int i = 0; i < m; i++){
            arr[i][0] = 1;
        }
        //Set First row to One
        for(int j = 0; j < n; j++){
            arr[0][j] = 1;
        }
        //Set the current value to summation of value top and left of it.
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
