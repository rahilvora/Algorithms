import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by rahilvora on 1/15/17.
 */
public class TopologicalSort {

    private int V;
    private LinkedList<Integer> adj[];
    TopologicalSort(int v){
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++){
            adj[i] =  new LinkedList<>();
        }
    }

    public void addEdge(int n1, int n2){
        adj[n1].add(n2);
    }
    private void topologicalSortUtil(boolean[] visited, Stack<Integer> stack, int n){
        visited[n] = true;
        int i;

        Iterator<Integer> it = adj[n].iterator();
        while(it.hasNext()){
            i = it.next();
            if(!visited[i]){
                topologicalSortUtil(visited, stack, i);
            }
        }
        stack.push(n);
    }
    private void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            visited[i] = false;
        }

        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                topologicalSortUtil(visited, stack, i);
            }
        }

        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[]){
        TopologicalSort obj = new TopologicalSort(6);

        // Create a graph given in the above diagram
        //Graph g = new Graph(6);
        obj.addEdge(5, 2);
        obj.addEdge(5, 0);
        obj.addEdge(4, 0);
        obj.addEdge(4, 1);
        obj.addEdge(2, 3);
        obj.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        obj.topologicalSort();
    }
}
