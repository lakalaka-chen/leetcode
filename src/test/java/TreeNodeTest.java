public class TreeNodeTest {
    public static void main(String[] args) {
        int nan = Integer.MAX_VALUE;
        TreeNode node = TreeNode.createTree(new int[]{1,2,3,nan,nan,4,5,6,7}, 0, 9);
    }
}
