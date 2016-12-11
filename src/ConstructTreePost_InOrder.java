import java.util.HashMap;

/**
 * Created by rahilvora on 7/20/16.
 */
public class ConstructTreePost_InOrder {
    public static void main(String args[]){
        int[] inorder = {12,15,17,18,19,20,25,26,27};
        int[] postOrder = {12,17,19,18,15,26,27,25,20};
        new ConstructTreePost_InOrder().constructTree(inorder, postOrder);

    }

    public TreeNode constructTree(int[] inorder, int[] postorder){
        if(inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return constructTree(inorder, 0 , inorder.length -1, postorder, 0, postorder.length -1, map);
    }

    public TreeNode constructTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> map){
        if(is > ie || ps > pe) return null;
        TreeNode root  = new TreeNode(postorder[pe]);

        int ri = map.get(postorder[pe]);
        TreeNode leftchild = constructTree(inorder, is, ri-1, postorder, ps, ps+ri-is-1, map);
        TreeNode rightchild = constructTree(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, map);
        //root.left = leftchild;
        //root.right = rightchild;
        return root;
    }

}

//class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode(int x) { val = x; }
//}
