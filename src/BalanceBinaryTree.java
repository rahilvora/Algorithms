/**
 * Created by rahilvora on 9/27/16.
 */
public class BalanceBinaryTree {
    public static void main(String args[]){

    }
    public boolean isBalanced(TreeNode root) {

        if(checkHeight(root) != -1)
            return true;
        return false;
    }

    public int checkHeight(TreeNode root){
        if(root == null){
            return 0; //height is 0
        }
        int leftheight = checkHeight(root.left);
        if(leftheight == -1){
            return -1;
        }
        int rightheight = checkHeight(root.right);
        if(rightheight == -1){
            return -1;
        }
        int heightDiff = leftheight - rightheight;
        if(Math.abs(heightDiff) > 1){
            return -1;
        }
        else{
            return 1 + Math.max(leftheight,rightheight);
        }
    }
}
