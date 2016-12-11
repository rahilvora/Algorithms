import java.util.HashSet;

/**
 * Created by rahilvora on 10/1/16.
 */
public class GoodNodes {
    public static void main(String args[]){
        int[] nums = {5,1,2,3,4,5};
        System.out.print(goodNodes(nums));
    }
    static int goodNodes(int[] points_to) {
        if(points_to.length == 0){
            return 0;
        }

        HashSet<Integer> setGoodNodes = new HashSet<>();
        setGoodNodes.add(1);
        int count = 0;
        int numNodes = points_to[0];
        if(numNodes != points_to.length -1){
            return 0;
        }
        for(int i = 1; i < points_to.length; i++){
            if(setGoodNodes.size() == numNodes){
                return count;
            }
            if(setGoodNodes.contains(points_to[i])){
                if(setGoodNodes.contains(points_to[i])) continue;

                setGoodNodes.add(i);
                count++;
                continue;
            }
            else{
                points_to[points_to[i]] = i;
                if(setGoodNodes.contains(points_to[i])) continue;
                setGoodNodes.add(points_to[i]);

                count++;
            }
        }
        return count;
    }
}
