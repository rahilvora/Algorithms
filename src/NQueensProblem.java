/**
 * Created by rahilvora on 7/23/16.
 */
public class NQueensProblem {
    public static void main(String agrs[]){
       Position[] arr =  new NQueensProblem().placeQueen(4);
        for (Position x:
             arr) {
            System.out.print(x.row +" "+x.col + "  ");
        }
    }

    public Position[] placeQueen(int n){
        Position[] positions = new Position[n];
        boolean hasSolution = solution(n, 0, positions);
        if(hasSolution){
            return positions;
        }
        else{
            return new Position[0];
        }
    }

    public boolean solution(int n, int row, Position[] positions){
        if(n == row){
            return true;
        }
        int col;
        for(col = 0; col < n; col++){
            boolean safe = true;
            for(int queen = 0; queen < row; queen++){
                if(positions[queen].col == col || positions[queen].row - positions[queen].col == row - col
                        || positions[queen].row + positions[queen].col == row + col){
                    safe = false;
                    break;
                }
            }
            if (safe) {
                positions[row] = new Position(row, col);
                if (solution(n, row + 1, positions)) {
                    return true;
                }
            }

        }
        return false;
    }

}

class Position{
    int row, col;
    Position(int row, int col){
        this.row = row;
        this.col = col;
    }
}