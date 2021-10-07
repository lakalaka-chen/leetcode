import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return null;
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode temp = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            result.add(temp.val);
        }

        return result;
    }
}
