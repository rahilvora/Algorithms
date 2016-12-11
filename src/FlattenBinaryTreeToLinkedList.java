import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by rahilvora on 9/28/16.
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String args[]){

    }
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> list = new  LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty()){
            root = stack.pop();
            list.add(root);
            if(root.right!= null){
                stack.push(root.right);
            }
            if(root.left!= null){
                stack.push(root.left);
            }
        }
    }
}
