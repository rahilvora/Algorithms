import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rahilvora on 7/20/16.
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {
    public static void main(String args[]){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.add(-1);
        l2.add(2);
        l2.add(3);
        l3.add(1);
        l3.add(-1);
        l3.add(-3);
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        //list.add(l4);

        System.out.print(new Triangle().minimumTotal(list));

    }
    public int minimumTotal(List<List<Integer>> triangle){
        int answer = 0;
        for(int i = 0; i < triangle.size(); i++){
            List<Integer> arr = new ArrayList<>();
            arr = triangle.get(i);
            arr.sort((o1, o2) -> o1.compareTo(o2));
            answer += arr.get(0);
        }

        return answer;
    }
}
