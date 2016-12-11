/**
 * Created by rahilvora on 8/30/16.
 */
public class SymmetricTree {
    public static void main(String args[]){

    }
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }
    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
            return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
