/**
 * Created by rahilvora on 1/12/17.
 */
public class Dijkstras {
    static final int V = 4;

    public int minDistance(int[] dist, boolean[] sptSet){
        int min_index = -1, min = Integer.MAX_VALUE;

        for(int i = 0; i < V; i++){
            if(sptSet[i] == false && dist[i] <= min){
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public void printUtil(int[] dist){
        for(int i = 0; i < V; i++){
            System.out.println(i + "\t\t"+ dist[i]);
        }
    }

    public void dijkstras(int[][] graph, int source){
        boolean[] sptSet = new boolean[V];
        int[] dist = new int[V];

        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[source] = 0;
        for(int count = 0; count < V; count++){
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for(int v = 0; v < V; v++){
                if(!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printUtil(dist);
    }


    public static void main(String args[]){
        int[][] graph = {
                            {0, 5, 0, 1},
                            {5, 0, 3, 2},
                            {0, 3, 0, 1},
                            {1, 2, 1, 0}
                        };

        Dijkstras obj = new Dijkstras();
        obj.dijkstras(graph, 0);
    }
}
