/**
 * Created by rahilvora on 11/30/16.
 */
public class RegexMatching {
    public static void main(String[] args){
        System.out.print(new RegexMatching().isMatch("rahil","r.h.*."));
    }
    public boolean isMatch(String s, String p) {
        boolean[][] matrix = new boolean[s.length() + 1][p.length() + 1];
        matrix[0][0] = true;
        for(int i = 1; i < matrix[0].length; i++){
            if(p.charAt(i - 1) == '*'){
                matrix[0][i] = matrix[0][i-2];
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(p.charAt(j - 1) == '.' || p.charAt(j-1) == s.charAt(i - 1)){
                    matrix[i][j] = matrix[i - 1][j - 1];
                }
                else if(p.charAt(j-1) == '*'){
                    matrix[i][j] = matrix[i][j-2];
                    if(p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)){
                        matrix[i][j] = matrix[i][j] | matrix[i-1][j];
                    }
                }
                else {
                    matrix[i][j] = false;
                }
            }
        }

        return matrix[s.length()][p.length()];
    }
}
