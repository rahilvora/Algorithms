import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahilvora on 1/22/17.
 */
public class BinaryPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root != null) pathHelper(paths, "",root);
        return paths;
    }
    public void pathHelper(List<String> paths, String path, TreeNode root){
        if(root.left == null && root.right == null){
            paths.add(path + root.val);
            return;
        }
        if(root.left != null) pathHelper(paths, path + root.val + "->", root.left);
        if(root.right != null) pathHelper(paths, path + root.val + "->", root.right);
    }

}
