import com.sun.source.tree.Tree;

import java.util.Stack;

/**
 * Created by rahilvora on 10/3/16.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    //recursive
    public int helper(TreeNode root, boolean isLeft){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(isLeft) return root.val;
            return 0;
        }
        return helper(root.left, true) + helper(root.right, false);
    }

    //Iterative apporach
    public int sumOfLeftLeaves1(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
