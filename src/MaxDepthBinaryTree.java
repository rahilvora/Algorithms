import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by rahilvora on 9/10/16.
 */
public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        int maxDepth = 0;
        stack.push(root);
        depth.push(1);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            int temp = depth.pop();
            maxDepth = Math.max(temp,maxDepth);
            if(node.left != null){
                stack.push(node.left);
                depth.push(temp + 1);
            }
            if(node.right != null){
                stack.push(node.right);
                depth.push(temp + 1);
            }
        }
        return maxDepth;
    }
    }


