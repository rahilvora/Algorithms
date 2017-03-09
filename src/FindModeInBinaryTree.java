import java.util.*;

/**
 * Created by rahilvora on 2/19/17.
 */
public class FindModeInBinaryTree {
    public static void main(String args[]){

    }
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!map.containsKey(node.val)){
                map.put(node.val,1);
            }
            else{
                int value = map.get(node.val);
                map.put(node.val, value++);
            }
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        int max = Collections.max(map.values());
        ArrayList<Integer> arr = new ArrayList<>();
        for(Integer key : map.keySet()){
            if(map.get(key) == max){
                arr.add(key);
            }
        }
        int[] answer = new int[arr.size()];
        int index = 0;
        for(int num: arr){
            answer[index] = num;
            index++;
        }
        return answer;
    }
}
