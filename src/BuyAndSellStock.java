/**
 * Created by rahilvora on 7/14/16.
 */
public class BuyAndSellStock {
    public static void main(String args[]){
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {1, 2, 4};
        int[] prices2 = {2, 1, 2, 0, 1};
        System.out.print(new BuyAndSellStock().maxProfit2(prices));
    }

    // When only one transaction is allowed
    public int maxProfit(int[] prices){
        int profit = 0;
        if(prices.length > 0){
            int min = prices[0];

            for(int i = 1; i < prices.length; i++){
                if(min > prices[i]){
                    min = prices[i];
                }
                else {
                    if(prices[i] - min > profit){
                        profit = prices[i] - min;
                    }
                }
            }
        }
        return profit;
    }

    // When n number of transactions are allowed
    public int maxProfit2(int[] prices){
        int n = prices.length;
        int profit = 0;
        int j = 0;
        int len = prices.length;
        while(n > 0){
            int nextIndex = 0;
            int min = prices[j];
            int temp = 0;
            int i = 0;
            for(i = j + 1; i < len; i++){
                if(min > prices[i]){
                    min = prices[i];
                    nextIndex = i ;
                }
                else{
                    if(prices[i] - min > temp){
                        temp = prices[i] - min;
                    }
                    if(i + 1 != len){
                        if(prices[i + 1] < prices[i]){
                            nextIndex = i+1;
                            break;
                        }
                    }
                }
            }
            profit += temp;
            if(i == len){
                break;
            }
            j = nextIndex;
            if(j >= len)
                break;
            n--;
        }
        return profit;
    }
}
