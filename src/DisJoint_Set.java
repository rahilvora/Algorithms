import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahilvora on 1/11/17.
 */
public class DisJoint_Set {

    private Map<Long, Node> map = new HashMap<>();
    class Node{
        int rank;
        long data;
        Node parent;
    }

    public void makeSet(long data){
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data, node);
    }

    public boolean union(long n1, long n2){
        Node node1 = map.get(n1);
        Node node2 = map.get(n2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if(parent1.data == parent2.data){
            return false;
        }
        if (parent1.rank >= parent2.rank) {
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1: parent1.rank;
            parent2.parent = parent1;
        }
        else {
            parent1.parent = parent2;
        }

        return true;

    }

    public long findSet(long data){
        return findSet(map.get(data)).data;
    }

    public Node findSet(Node node){
        Node parent = node.parent;
        if(parent == node){
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String args[]){
        DisJoint_Set ds = new DisJoint_Set();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);

        ds.union(1,2);
        ds.union(3,4);
        ds.union(5,6);
        ds.union(3,5);
        ds.union(1,3);

        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(5));
    }
}
