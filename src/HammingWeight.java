/**
 * Created by rahilvora on 12/17/16.
 */
public class HammingWeight {

    public static void main(String args[]){
        System.out.print(new HammingWeight().hammingWeight(1337^7331));
    }

    public int hammingWeight(int n){
        int count = 0;

        for(int i = 1; i < 33; i++){
            if(bits(n,i)){
                count++;
            }
        }

        return count;

    }
    public boolean bits(int n, int i){
        return (n & (1 << i)) != 0;
    }
}
