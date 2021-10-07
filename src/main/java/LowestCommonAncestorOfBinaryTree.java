import java.util.ArrayList;

public class LowestCommonAncestorOfBinaryTree {
    ArrayList<TreeNode> plist;
    ArrayList<TreeNode> qlist;
    ArrayList<TreeNode> path;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        plist = new ArrayList<>();
        qlist = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root,p,q);
        int loc = 0;
        while (loc < plist.size() && loc < qlist.size() && plist.get(loc) == qlist.get(loc)) loc++;
        return plist.get(loc-1);
    }
    void dfs(TreeNode cur, TreeNode p, TreeNode q) {
        path.add(cur);
        if (cur == p)
            plist = new ArrayList<>(path);
        else if (cur == q)
            qlist = new ArrayList<>(path);

        if (cur.left != null) dfs(cur.left, p, q);
        if (cur.right != null) dfs(cur.right, p, q);
        path.remove(path.size()-1);
    }
}