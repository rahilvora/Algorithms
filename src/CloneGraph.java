import java.util.*;

/**
 * Created by rahilvora on 1/20/17.
 */
public class CloneGraph {
    class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode rootNew = new UndirectedGraphNode(node.label);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        map.put(node, rootNew);
        queue.add(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();
            List<UndirectedGraphNode> currNeighbours = curr.neighbors;

            for(UndirectedGraphNode aNeighbour : currNeighbours){
                if(!map.containsKey(aNeighbour)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbour.label);
                    map.put(aNeighbour, copy);
                    map.get(curr).neighbors.add(copy);
                    queue.add(aNeighbour);
                }
                else{
                    map.get(curr).neighbors.add(map.get(aNeighbour));
                }
            }
        }
        return rootNew;
    }
    public static void main(String args[]){

    }
}
