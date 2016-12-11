/**
 * Created by rahilvora on 12/3/16.
 */
public class SortedArrayToBST {



    public TreeNode createTree(int[] nums,int  start, int end){
        if(start > end){
            return null;
        }
        int mid =  (start + (end - start) / 2);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);
        return root;
    }
}
