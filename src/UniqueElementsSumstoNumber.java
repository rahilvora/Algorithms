/**
 * Created by rahilvora on 10/4/16.
 */
import java.util.HashSet;
    public class UniqueElementsSumstoNumber {
        public static void main(String[] args) {
            HashSet set = new HashSet();
            int[] arr = {6,4,4,4,7,3,1};
            int sum = 10;

            for (int a : arr) {	set.add(a);	}
            for (int a : arr) {
                if (set.contains(sum - a)) {
                    System.out.println("[" + a + "," + (sum-a) + "]");
                    set.remove(a);
                    set.remove(sum-a);
                }
            }
        }
    }

