import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    final String NULL = "#";
    final String SPLIT = "_";
    public String serialize(TreeNode root) {
        List<String> strlist = new LinkedList<>();
        preorder(root, strlist);
        if (strlist.isEmpty())
            return "";
        StringBuilder strbuilder = new StringBuilder();
        for (String str: strlist) {
            strbuilder.append(str);
            strbuilder.append(SPLIT);
        }
        strbuilder.delete(strbuilder.length()-1, strbuilder.length());
        return strbuilder.toString();
    }

    void preorder(TreeNode node, List<String> strlist) {
        if (node == null)
            strlist.add(NULL);
        else {
            strlist.add(Integer.toString(node.val));
            preorder(node.left, strlist);
            preorder(node.right, strlist);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        List<String> strlist = new LinkedList<>(Arrays.asList(data.split(SPLIT)));
        return buildTree(strlist);
    }

    TreeNode buildTree(List<String> strlist) {
        String cur = strlist.get(0);
        strlist.remove(0);
        if (cur.equals(NULL)) return null;
        int val = Integer.valueOf(cur);
        TreeNode node = new TreeNode(val);
        node.left = buildTree(strlist);
        node.right = buildTree(strlist);
        return node;
    }
}
