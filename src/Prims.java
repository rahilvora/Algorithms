import java.util.PriorityQueue;

/**
 * Created by rahilvora on 1/12/17.
 */
public class Prims {
    static final int V = 5;

    private int minDistance(int[] dist, boolean[] mstSet){
        int min_index = -1, min = Integer.MAX_VALUE;

        for(int i = 0; i < V; i++){
            if(mstSet[i] == false && dist[i] <= min){
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    private void printUtil(int[] parent, int[] dist, int[][] graph){
        for(int i = 1; i < V; i++){
            System.out.println(parent[i] + "-" + i +" " + dist[i]);
        }
    }

    public void prims(int[][] graph){
        int[] parent = new int[V];

        int[] dist = new int[V];

        boolean[] mstSet = new boolean[V];

        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        dist[0] = 0;
        parent[0] = -1;
        for(int i = 0; i < V; i++){
            int u = minDistance(dist, mstSet);
            mstSet[u] = true;

            for(int j = 0; j < V; j++){
                if(mstSet[j] == false && graph[u][j] < dist[j] && graph[u][j] != 0){
                    parent[j] = u;
                    dist[j] = graph[u][j];
                }
            }
        }
        printUtil(parent, dist, graph);
    }

    public static void main(String args[]){
        int[][] graph = {
                            {0, 2, 0, 6, 0},
                            {2, 0, 3, 8, 5},
                            {0, 3, 0, 0, 7},
                            {6, 8, 0, 0, 9},
                            {0, 5, 7, 9, 0}
                        };
        Prims obj = new Prims();
        obj.prims(graph);


    }
}
