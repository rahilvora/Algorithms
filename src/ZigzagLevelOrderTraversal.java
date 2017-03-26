import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rahilvora on 3/18/17.
 */
public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer  = new ArrayList<>();
        if(root == null) return answer;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(0);

        while(!stack.isEmpty()){
            node = stack.pop();
            int value = depth.pop();
            if(value % 2 == 0){
                if(answer.size()-1 < value){
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    answer.add(value, list);
                }
                else{
                    answer.get(value).add(node.val);
                }
            }
            else{
                if(answer.size()-1 < value){
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    answer.add(value, list);
                }
                else{
                    answer.get(value).add(0,node.val);
                }
            }
            if(node.right != null){
                stack.push(node.right);
                depth.push(value + 1);
            }
            if(node.left != null){
                stack.push(node.left);
                depth.push(value + 1);
            }
        }
        return answer;
    }
}
