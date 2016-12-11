/**
 * Created by rahilvora on 12/2/16.
 */
public class CoinChange {
    public static void main(String[] args){

    }
    public int coinChange(int[] coins, int amount) {
        //this array consist of number of coins required to form that respective total
        // For example T[7] = 1. i.e. 1 coin of 7 is required to form total 7. Index is the total amount
        int[] T = new int[amount + 1];

        //This array stores the index of the coin
        int[] R = new int[amount + 1];

        T[0] = 0;

        for(int i = 1; i <= amount; i++){
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }

        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <=amount; j++){
                if(j >= coins[i]){
                    if(1 + T[j - coins[i]] < T[j]){
                        T[j] =  1 + T[j - coins[i]];
                        R[j] = i;
                    }
                }
            }
        }
        return T[amount] == Integer.MAX_VALUE - 1 ? -1:T[amount];
    }
}
