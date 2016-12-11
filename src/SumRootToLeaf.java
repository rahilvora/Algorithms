import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rahilvora on 9/23/16.
 */
public class SumRootToLeaf {
    public static void main(String args){

    }
    public int sumNumbers(TreeNode root) {
        int sum = 0, val = 0;
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> valStack = new Stack<Integer>();
        stack.push(root);
        valStack.push(root.val);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            val = valStack.pop();
            if(node.right == null && node.left == null){
                sum += val;
            }
            if(node.right != null){
                stack.push(node.right);
                valStack.push(val*10+node.right.val);
            }
            if(node.left != null){
                stack.push(node.left);
                valStack.push(val*10+node.left.val);
            }
        }

        return sum;
    }

    //Recursive Solution1

    public int sumNumber1(TreeNode node){
        return sumNumber1(node,0);
    }
    public int sumNumber1(TreeNode node, int sum){
        if(node ==  null)
        return 0;
        else{
            sum  = sum*10 + node.val;
            if(node.left == null && node.right == null){
                return sum;
            }
            return sumNumber1(node.left,sum) + sumNumber1(node.right,sum);
        }
    }
}
