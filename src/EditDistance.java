/**
 * Created by rahilvora on 9/13/16.
 */
public class EditDistance {
    public static void main(String args[]){
        System.out.print(new EditDistance().minDistance("azced".toCharArray(), "abcdef".toCharArray()));
    }
    public int minDistance(char[] str1, char[] str2){
        int temp[][] = new int[str1.length+1][str2.length+1];

        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }

        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }

        for(int i=1;i <=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
                }
            }
        }
        //printActualEdits(temp, str1, str2);
        return temp[str1.length][str2.length];

    }
    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
}
