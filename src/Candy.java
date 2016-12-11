import java.util.ArrayList;
import java.util.Map;

/**
 * Created by rahilvora on 7/12/16.
 */
public class Candy {

    public static void main(String args[]){
        int[] ratings = {4, 2, 3, 4,1, };
        int[] ratings1 = {0};
        System.out.print(candies(ratings));
    }
    public static int candies(int[] ratings){
        int[] temp = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++){
            temp[i] = 1;
        }

        for(int j = 1; j < ratings.length; j++){
            if(ratings[j] > ratings[j - 1]){
                temp[j] = temp[j - 1] + 1;
            }
        }

        for(int x = ratings.length - 1; x > 0; x--){
            if(ratings[x] < ratings[x - 1]){
                temp[x - 1] = Math.max(temp[x] + 1, temp[ x - 1]);
            }
        }
        int answer = 0;
        for ( int x:
             temp) {
            answer += x;
        }
        return answer;
    }
}
