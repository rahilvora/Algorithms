import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by rahilvora on 1/10/17.
 */
public class BFS_Graph {
    public static void main(String args[]){
        GraphII obj = new GraphII(4);

        obj.addEdge(0,1);
        obj.addEdge(0,2);
        obj.addEdge(1,2);
        obj.addEdge(2,0);
        obj.addEdge(2,3);
        obj.addEdge(3,3);

        obj.BFS(2);

    }
}
class GraphII{

    private int vertices;
    private LinkedList<Integer> adj[];

    GraphII(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
    }

    public void BFS(int s){
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()){
            s = queue.poll(); //Returning null + removing operations: poll(), Throwing exception + removing operations: pop()docs
            System.out.print(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFS(int s){
        boolean[] visited = new boolean[vertices];
        DFSUtil(s, visited);
    }
    public void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }
}
