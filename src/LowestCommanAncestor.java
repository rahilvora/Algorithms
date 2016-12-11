/**
 * Created by rahilvora on 8/30/16.
 */
public class LowestCommanAncestor {
    public static void main(String args[]){

    }
    //Non-Recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else {
                return root;
            }
        }
    }
    //Recursive
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor1(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor1(root.right, p, q);
        }
        else{
            return root;
        }
    }
}
