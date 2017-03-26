import java.util.Arrays;

/**
 * Created by rahilvora on 1/19/17.
 */
public class GraphValidTree {

    //My approach
    public boolean validTree(int n, int[][] edges) {
        int[] answer = new int[n];
        for(int i = 0; i < edges.length; i++){
            answer[edges[i][1]]++;
            if(answer[edges[i][1]] > 1){
                return false;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(answer[i] == 0 && count < 2){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
    //Union Find Approach

    public boolean validTreeI(int n, int[][] edges) {
        int[]  nums = new int[n];
        Arrays.fill(nums, -1);

        for(int i = 0; i < n; i++){
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if(x == y) return false;

            nums[x] = y;
        }
        return true;
    }
    public int find(int[] num, int i){
        if(num[i] == -1) return i;
        return find(num,num[i]);
    }
    public static void main(String args[]){
        int[][] edges =  {{1,0},{2,0}};
        System.out.print(new GraphValidTree().validTree(3, edges));
    }
}
