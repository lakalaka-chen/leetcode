public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() { this.left = null; this.right = null; }
    TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode createTree(int[] arr, int loc, int len) {
        TreeNode node = new TreeNode(arr[loc]);
        if (loc*2+1 < len)
            node.left = arr[loc*2+1] == Integer.MAX_VALUE ? null : createTree(arr, loc*2+1, len);
        if (loc*2+2 < len)
            node.right = arr[loc*2+2] == Integer.MAX_VALUE ? null : createTree(arr, loc*2+2, len);
        return node;
    }
    public static TreeNode createTree2(int[] arr, int loc, int len) {
        TreeNode node = new TreeNode(arr[loc]);
        if (loc*2+1 < len)
            node.left = arr[loc*2+1] == Integer.MAX_VALUE ? null : createTree(arr, loc*2+1, len);
        if (loc*2+2 < len)
            node.right = arr[loc*2+2] == Integer.MAX_VALUE ? null : createTree(arr, loc*2+2, len);
        return node;
    }
}
