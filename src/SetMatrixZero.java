import java.util.Arrays;

/**
 * Created by rahilvora on 7/21/16.
 */
public class SetMatrixZero {
    public static void main(String args[]){
        int[][] matrix = {{0},{1}};
        new SetMatrixZero().setZeroes(matrix);
    }
    public void setZeroes(int[][] matrix){
        int n = matrix.length;
        Boolean[] row = new Boolean[n];
        Boolean[] col = new Boolean[matrix[0].length];
        Arrays.fill(row, Boolean.FALSE);
        Arrays.fill(col, Boolean.FALSE);

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j <matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
