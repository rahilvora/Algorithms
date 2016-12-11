import java.util.*;

/**
 * Created by rahilvora on 9/11/16.
 */
public class BinaryLevelOrderTraversal {
    public static void main(String args[]){

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        queue.add(root);
        depth.add(0);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            int level = depth.remove();
            try{
                ans.get(level);
            }
            catch (Exception e){
                ans.add(level, new ArrayList<>());
            }
            ans.get(level).add(temp.val);

            if(temp.left != null){
                queue.add(temp.left);
                depth.add(level + 1);
            }
            if(temp.right != null){
                queue.add(temp.right);
                depth.add(level + 1);
            }
        }
        return ans;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        depth.add(0);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            int level = depth.remove();
            try{
                ans.get(level);
            }
            catch (Exception e){
                ans.add(level, new ArrayList<>());
            }
            ans.get(level).add(temp.val);

            if(temp.left != null){
                queue.add(temp.left);
                depth.add(level + 1);
            }
            if(temp.right != null){
                queue.add(temp.right);
                depth.add(level + 1);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
