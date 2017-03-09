/**
 * Created by rahilvora on 1/20/17.
 */
public class NumberofIslands {
    private int n, m;
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        n = grid.length;
        m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    DFSMarking(grid, i , j);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFSMarking(char[][] grid, int i , int j){
        if(i < 0 || j < 0 || i>=n || j>=m || grid[i][j]!='1') return;
        grid[i][j] = '0';
        DFSMarking(grid,i+1,j);
        DFSMarking(grid,i-1,j);
        DFSMarking(grid,i,j+1);
        DFSMarking(grid,i,j-1);
    }

    public static void main(String args[]){
        char[][] grid = {{'0','1','0'},{'0','1','0'}};
        System.out.print(new NumberofIslands().numIslands(grid));
    }
}
