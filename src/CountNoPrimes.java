import java.util.ArrayList;

/**
 * Created by rahilvora on 9/2/16.
 */
public class CountNoPrimes {
    public static void main(String args[]){

    }
    public int countPrimes(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        for(int i = 2; i <= n; i++){
            arr.add(i);
        }

        return count;
    }

}
