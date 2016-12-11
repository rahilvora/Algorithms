
import com.sun.javafx.collections.SortableList;
import sun.misc.Queue;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static javafx.scene.input.KeyCode.T;

/**
 * Created by rahilvora on 6/29/16.
 */
public class Graph {
    public static int[][] adjacency_matrix;
    ArrayList<GraphNode> mainArray = new ArrayList<GraphNode>();
    Graph(int v){
        adjacency_matrix = new int[v][v];
        for(int i = 0; i < v ; i++){
            for(int j = 0; j < v ; j++){
                if(i == j){
                    adjacency_matrix[i][j] = 0;
                }
                else{
                    adjacency_matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }
    public static void main(String args[]) throws InterruptedException {
        int vertices = 0, edges =  0, count = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of vertices");
        vertices = in.nextInt();
        System.out.print("Enter the number of edges");
        edges = in.nextInt();
        Graph object = new Graph(vertices);
        while(count < edges){
            System.out.print("Enter the start vertex");
            int to = in.nextInt();
            System.out.print("Enter the end vertex");
            int from = in.nextInt();
            System.out.print("Enter the path value");
            int value = in.nextInt();
            object.makeEdge(to, from, value);
            count++;
        }
        //object.BFS(adjacency_matrix, 2);
        //object.DFS(adjacency_matrix, 0);
        //object.prims(adjacency_matrix, 0);
        //object.krushkal(adjacency_matrix);
        object.dijktras(adjacency_matrix, 0);
    }
    public void makeEdge(int to, int from, int value){
        adjacency_matrix[to][from] = value;
        adjacency_matrix[from][to] = value;
    }

    public void BFS(int [][] graph, int root) throws InterruptedException {
        Queue queue = new Queue();
        for(int i = 0; i < graph.length; i++){
            GraphNode node = new GraphNode(i);
            mainArray.add(node);
        }
        for(int x = 0; x < mainArray.size(); x++){
            for(int j =0; j< graph.length; j++){
                if(graph[x][j] != 0 && graph[x][j] != Integer.MAX_VALUE){
                    mainArray.get(x).children.add(mainArray.get(j));
                }
            }
        }
        GraphNode temp = mainArray.get(root);
        queue.enqueue(temp);
        while(!queue.isEmpty()){
            temp =(GraphNode) queue.dequeue();
            if(temp.visited != true){
                System.out.println(temp.name);
                temp.visited = true;
                for (GraphNode x:
                        temp.children) {
                    if(x.visited != true)
                    queue.enqueue(x);
                }
            }
        }
    }

    public void DFS(int[][] graph, int root){
        Stack stack = new Stack();
        for (int i = 0; i < graph.length; i++){
            GraphNode node = new GraphNode(i);
            mainArray.add(node);
        }

        for(int x = 0; x < mainArray.size(); x++){
            for(int j =0; j< graph.length; j++){
                if(graph[x][j] != 0 && graph[x][j] != Integer.MAX_VALUE){
                    mainArray.get(x).children.add(mainArray.get(j));
                }
            }
        }
        GraphNode temp = mainArray.get(root);
        stack.push(temp);
        temp.visited = true;

        while(!stack.empty()){
            temp =(GraphNode) stack.pop();
            if(temp.visited == true) {
                System.out.println(temp.name);
            }
            for (GraphNode x:
                 temp.children) {
                if(x.visited != true)
                stack.add(x);
                x.visited = true;
                //break;
            }
        }
    }

    public void prims(int[][] graph, int root){
        ArrayList<Edge> paths =  new ArrayList<Edge>();

        for(int i = 0; i < graph.length; i++){
            GraphNode node = new GraphNode(i,Integer.MAX_VALUE, null);
            mainArray.add(node);
        }

        for(int x = 0; x < mainArray.size(); x++){
            for(int j = 0; j < graph.length; j++){
                if(graph[x][j] != 0 && graph[x][j] != Integer.MAX_VALUE){
                    mainArray.get(x).children.add(mainArray.get(j));
                }
            }
        }

        mainArray.get(root).cost = 0;
        while(!mainArray.isEmpty()){
            GraphNode temp = mainArray.get(0);

            for(int j = 0; j < mainArray.size() - 1; j++){

                if(mainArray.get(j).cost < mainArray.get(j + 1).cost){
                    temp = mainArray.get(j);
                }
            }
            mainArray.remove(temp);
            if(temp.parent != null){
                paths.add(new Edge(temp.name, temp.parent.name));
            }
            for (GraphNode x:
                 temp.children) {
                if(x.cost > graph[temp.name][x.name]){
                    x.cost = graph[temp.name][x.name];
                    x.parent = temp;
                }
            }
        }
        for (Edge x:
             paths) {
            System.out.println(x.startNode +" " +x.endNode);
        }
    }
    public void krushkal(int [][] graph){
        for(int i = 0; i < graph.length; i++){
            GraphNode node = new GraphNode(i,Integer.MAX_VALUE, null);
            mainArray.add(node);
        }
        DisjointSet object  = new DisjointSet(mainArray);

        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0; i < graph.length; i++) {
            for(int j=0; j < i; j++) {
                if(graph[i][j] != 0 && graph[i][j] != Integer.MAX_VALUE)
                edges.add(new Edge(i, j, graph[i][j]));
            }
        }

        Collections.sort(edges, (o1, o2) ->
                o1.weight - o2.weight);
        ArrayList<Edge> paths = new ArrayList<>();
        for (Edge e:
             edges) {
            if(object.find(mainArray.get(e.startNode)) != object.find(mainArray.get(e.endNode))){
                paths.add(new Edge(e.startNode,e.endNode));
                object.union(mainArray.get(e.startNode), mainArray.get(e.endNode));
            }
        }

        for (Edge x:
                paths) {
            System.out.println(x.startNode +" " +x.endNode);
        }
    }
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < dist.length; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    public void dijktras(int[][] graph, int source){

        int dist[] = new int[graph.length];
        Boolean[] sptSet = new Boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[source] = 0;
        for(int count = 0; count < graph.length - 1; count ++){
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for(int v= 0; v < graph.length; v++){

                if (!sptSet[v] && graph[u][v]!=0 && graph[u][v]!=Integer.MAX_VALUE &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
            }
        }
            System.out.println("Vertex   Distance from Source");
            for (int i = 0; i < dist.length; i++)
                System.out.println(i+" \t\t "+dist[i]);
    }
}

class GraphNode{
    public int name;
    ArrayList<GraphNode> children = new ArrayList<GraphNode>();
    public int distance;
    public GraphNode parent;
    boolean visited;
    int cost;
    GraphNode(){
        visited = false;
        parent = null;
        distance = 0;
    }
    GraphNode(int name){
        this.visited = false;
        this.name = name;
    }
    GraphNode(int name, int cost, GraphNode parent){
        this.name = name;
        this.cost = cost;
        this.parent = parent;
    }
    //GraphNode(int name, int cost, int previous )
}

class Edge {
    int startNode;
    int endNode;
    int weight;

    Edge(int startNode, int endNode){
        this.startNode = startNode;
        this.endNode = endNode;
    }

    Edge(int startNode, int endNode, int weight){
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }
}