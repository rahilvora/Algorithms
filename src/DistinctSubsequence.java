/**
 * Created by rahilvora on 10/11/16.
 */
public class DistinctSubsequence {
    public static void main(String agrs[]){
        System.out.println(new DistinctSubsequence().numDistinct("rabbbit","rabbit"));
    }
    public int numDistinct(String s, String t) {
        int mainStringLength = s.length(), subsequenceLength = t.length();
        int[][] matrix = new int[mainStringLength + 1][subsequenceLength + 1];

        matrix[0][0] = 1;

        //Make First Row 0
        for(int i = 1;i <= subsequenceLength; i++){
            matrix[0][i] = 0;
        }

        //Make First Column 1
        for(int j = 1; j <= mainStringLength; j++){
            matrix[j][0] = 1;
        }

        for(int i = 1; i <= mainStringLength; i++){
            for(int j = 1; j <= subsequenceLength; j++){
                //if char are equal add diagonal value and value above it
                if(s.charAt(i-1) == t.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
                }
                else{
                    matrix[i][j] = matrix[i -1][j];
                }
            }
        }

        return matrix[matrix.length -1][matrix[0].length -1];
    }
}
