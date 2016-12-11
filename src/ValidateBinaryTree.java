import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rahilvora on 9/27/16.
 */
public class ValidateBinaryTree {
    public static void main(String args[]){

    }
    public boolean isValidBST(TreeNode node) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                TreeNode temp = stack.pop();
                arr.add(temp.val);
                node = node.right;
            }
        }
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i-1) > arr.get(i)){
                return false;
            }
        }
        return true;
    }
}
