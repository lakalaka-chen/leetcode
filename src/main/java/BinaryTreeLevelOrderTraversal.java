import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> element = new ArrayList<>();
        int sz = 0;
        TreeNode temp = null;

        queue.add(root);

        while (!queue.isEmpty()) {
            sz = queue.size();
            for (int i = 0; i < sz; i ++) {
                temp = queue.poll();
                element.add(temp.val);
                if (temp.left != null)  queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            result.add(new ArrayList<>(element));
            element.clear();
        }

        return result;

    }
}