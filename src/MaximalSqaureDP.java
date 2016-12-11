/**
 * Created by rahilvora on 11/25/16.
 */
public class MaximalSqaureDP {
    public static void main(String args[]){
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.print(new MaximalSqaureDP().maximalSquare(matrix));
    }
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0,
            rows =  matrix.length,
            columns= rows > 0 ? matrix[0].length : 0;
            int[][] dp = new int[ rows + 1 ][ columns + 1 ];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                if(matrix[ i - 1] [j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1;
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare * maxSquare;
    }
}
