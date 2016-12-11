/**
 * Created by rahilvora on 7/29/16.
 */
public class CuttingRodProblem {
    public static void main(String args[]){
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = prices.length;
        System.out.print(new CuttingRodProblem().cutRod(prices, size));
    }
    static int max(int a, int b){
        return (a > b) ? a : b;
    }

    static int cutRod(int price[], int n){
        int[] val = new int[n + 1];
        val[0] = 0;
        int i, j;

        // Build the table val[] in bottom up manner and return the last entry
        // from the table
        for (i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (j = 0; j < i; j++)
                max_val = max(max_val, price[j] + val[i-j-1]);
            val[i] = max_val;
        }

        return val[n];
    }
}
