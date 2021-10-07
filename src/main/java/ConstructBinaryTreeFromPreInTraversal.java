public class ConstructBinaryTreeFromPreInTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int i = 0;
        for (; i < inorder.length && inorder[i] != rootValue; i ++);

        root.left = _buildTree(preorder, 1, inorder, 0, i);
        root.right = _buildTree(preorder, i+1, inorder, i+1, inorder.length);

        return root;
    }
    TreeNode _buildTree(int[] preorder, int ps, int[] inorder, int is, int ie) {
        if (is == ie)
            return null;
        TreeNode result = new TreeNode(preorder[ps]);

        int i = is;
        for (; i < ie && inorder[i] != preorder[ps]; i ++);

        result.left = _buildTree(preorder, ps+1, inorder, is, i);
        result.right = _buildTree(preorder, i-is+ps+1, inorder, i+1, ie);

        return result;
    }

}

