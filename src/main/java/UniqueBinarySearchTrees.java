import java.util.Map;
import java.util.HashMap;

class UniqueBinarySearchTrees {
    Map<Integer, Integer> dp = new HashMap<>();

    public int numTrees(int n) {

        if (n == 0) return 1;
        if (n <= 2) return n;

        if (dp.containsKey(n))
            return dp.get(n);

        int result = 0;
        for (int i = 0; i < n; i ++)
            result += numTrees(i) * numTrees(n-1-i);

        dp.put(n, result);

        return result;

    }
}
