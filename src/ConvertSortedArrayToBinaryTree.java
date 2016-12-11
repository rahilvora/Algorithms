/**
 * Created by rahilvora on 9/27/16.
 */
public class ConvertSortedArrayToBinaryTree {
    public static void main(String args[]){
        int[] nums = {1,2,3,4,5,6,7};
        new ConvertSortedArrayToBinaryTree().sortedArrayToBST(nums);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length);
    }
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
