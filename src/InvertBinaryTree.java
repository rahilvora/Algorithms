import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rahilvora on 9/14/16.
 */
public class InvertBinaryTree {
    public static void main(String args[]){

    }

    // Iterative approach;
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        return root;
    }

    // Recursive approach;

    public TreeNode invertTree1(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }
}
