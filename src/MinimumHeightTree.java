import java.util.*;

/**
 * Created by rahilvora on 1/18/17.
 */
public class MinimumHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new HashSet<Integer>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(adj.get(i).size() == 1){
                leaves.add(i);
            }
        }

        while(n > 2){
            n = n - leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf: leaves){
                int j = adj.get(leaf).iterator().next();
                adj.get(j).remove(leaf);
                if(adj.get(j).size() == 1){
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String args[]){

    }
}
