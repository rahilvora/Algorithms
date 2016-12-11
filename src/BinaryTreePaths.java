import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rahilvora on 9/13/16.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        List<String> ans = new ArrayList<>();
        StringBuffer str = new StringBuffer();
        if(root == null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        stack.push(root);
        level.push(1);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            int value = level.pop();
            arr.add(temp.val);
            //str.append(temp.val);
            //str.append("->");
            if(temp.left != null){
                stack.push(temp.left);
                level.push(value + 1);
            }
            if(temp.right != null){
                stack.push(temp.right);
                level.push(value + 1);
            }
            // On leaf node
            if(temp.left == null && temp.right == null){
                for(int i = 0; i < arr.size() -1;i++){
                    str.append(arr.get(i) + "->");
                }
                str.append(arr.size()-1);
                ans.add(str.toString());
                str = null;
                arr.remove(arr.size() - 1 - value);
            }


        }
        return ans;
    }
}
