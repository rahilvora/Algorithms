/**
 * Created by rahilvora on 7/29/16.
 */
public class LogestCommonSubsequence {
    public static void main(String args[]){
        String s1 = "abcdaf";
        String s2 = "acbcf";
        System.out.print(new LogestCommonSubsequence().lcsDP(s1.toCharArray(), s2.toCharArray()));
    }
    public int lcsDP(char[] c1, char[] c2){
        int[][] temp = new int[c1.length + 1][c2.length + 1];
        int max = 0;
        for(int i = 1 ; i < temp.length; i++){
            for (int j = 1; j < temp[i].length; j++){
                if(c1[i - 1] == c2[j -1]){
                    temp[i][j] = temp[i-1][j-1] + 1;
                }
                else{
                    temp[i][j] = Math.max(temp[i-1][j],temp[i][j-1]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
//        StringBuffer str = new StringBuffer();
//        for(int i = temp.length -1; i > 0; i--){
//            for(int j = temp[0].length - 1; j > 0; j--){
//                if(temp[i-1][j-1] + 1 == max){
//                    str.append(c2[i]);
//                }
//            }
//        }
        return max;
    }
}
