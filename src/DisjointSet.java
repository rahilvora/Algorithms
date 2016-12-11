import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rahilvora on 7/11/16.
 */
public class DisjointSet {
    HashMap<GraphNode,GraphNode> Parent = new HashMap<>();
    HashMap<GraphNode,Integer> Rank = new HashMap<>();
    ArrayList<GraphNode> temp = new ArrayList<>();
    DisjointSet(ArrayList<GraphNode> members){
        int size = members.size() - 1;
        while(size > -1){
            temp.add(members.get(size));
            size--;
        }
        for (GraphNode x:
             temp) {
            Parent.put(x,x);
            Rank.put(x,0);
        }
    }

    public GraphNode find(GraphNode item){
        if(Parent.get(item) == item){
            return item;
        }
        else{
            return find(Parent.get(item));
        }
    }

    public void union(GraphNode set1, GraphNode set2){

        if(Rank.get(set1) > Rank.get(set2)){
            Parent.put(set2, set1);
        }
        else if(Rank.get(set1) < Rank.get(set2)){
            Parent.put(set1,set2);
        }
        else {
            Parent.put(set1,set2);
            int temp = Rank.get(set1);
            Rank.put(set1,++temp);
        }
    }
}
