import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rahilvora on 9/27/16.
 */
public class BinaryTreeToLinkedList {
    public static void main(String args[]){

    }
    // My Approach
    public ArrayList<LinkedList<TreeNode>> createNode(TreeNode root){
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();
        Queue<TreeNode> queue = new PriorityQueue<>();
        Queue<Integer> depth = new PriorityQueue<>();
        LinkedList<TreeNode> LinkedList = new LinkedList<>();
        list.get(0).add(root);
        queue.add(root);
        depth.add(0);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            int value  = depth.remove();
            LinkedList.add(temp);
            try {
                list.get( value );
            } catch ( IndexOutOfBoundsException e ) {
                list.add( value, LinkedList);
            }
            if(temp.left != null){
                queue.add(temp.left);
                depth.add(value+1);
            }
            if(temp.right != null){
                queue.add(temp.left);
                depth.add(value+1);
            }
        }
        return list;
    }
    //CTCI approach


}
