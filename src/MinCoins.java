import java.util.ArrayList;

/**
 * Created by rahilvora on 7/13/16.
 */
public class MinCoins {
    public static void main(String args[]){
        int value = 121;
        int[] coins = {1,2,5,10,20,50,100,500,1000};
        minCoinCal(coins, value);
    }

    public static void minCoinCal(int[] coins, int value){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = coins.length - 1; i >= 0; i--){
                if(value - coins[i] >= 0){
                    value -= coins[i];
                    result.add(coins[i]);
                }
        }
        for (Integer x:
             result) {
            System.out.print(x + " ");
        }
    }
}
