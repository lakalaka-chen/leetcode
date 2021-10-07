import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (hp.containsKey(target - nums[i])) {
                return new int[]{ hp.get(target-nums[i]), i };
            }
            hp.put(nums[i], i);
        }
        return null;
    }
}
