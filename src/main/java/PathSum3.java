import java.util.HashMap;

public class PathSum3 {
    int total=0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        getSum(root,sum,0,map);

        return total;
    }

    public void getSum(TreeNode root, int sum, int curr, HashMap<Integer,Integer> map){
        if(root==null) return;

        curr+=root.val;

        if(map.containsKey(curr-sum)) total+=map.get(curr-sum);
        map.put(curr,map.getOrDefault(curr,0)+1);

        getSum(root.left,sum,curr,map);
        getSum(root.right,sum,curr,map);

        map.put(curr,map.get(curr)-1);
    }
}