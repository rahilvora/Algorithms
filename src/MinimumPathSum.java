/**
 * Created by rahilvora on 3/8/17.
 */
public class MinimumPathSum {
    public static void main(String args[]){
        int[][] arr = {{1, 3, 5, 8}, {4, 2, 1, 7}, {4, 3, 2, 3}};
        new MinimumPathSum().minPathSumI(arr);

    }
    // Using Extra Space
    public int minPathSum(int[][] grid) {
        int[][] answer = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0){
                    answer[i][j] = grid[i][j];
                }
                else if(i == 0 && j < grid[0].length){
                    answer[i][j] = answer[i][j-1] + grid[i][j];
                }
                else if(j == 0 && i < grid.length){
                    answer[i][j] = grid[i][j] + answer[i-1][j];
                }
                else if(i < grid.length  && j < grid[0].length){
                    answer[i][j] = grid[i][j] + Math.min(answer[i-1][j], answer[i][j-1]);
                }
            }
        }
        return answer[answer.length-1][answer[0].length - 1];
    }

    //Without Using Extra Space
    public int minPathSumI(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] answer = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 && j == 0){
                    grid[i][j] = grid[i][j];
                }
                else if(i == 0 && j < cols){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }
                else if(j == 0 && i < rows){
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                }
                else if(i < rows  && j < cols){
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[rows-1][cols - 1];
    }

}
