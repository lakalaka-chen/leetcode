import java.util.Arrays;

public class PartitionEqualSubsetSum {
    boolean ans = false;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)
            return false;

        int target = sum/2;
        int len = nums.length;
        boolean[] dp = new boolean[target+1];

        for (int i = 0; i < len; i ++) {
            for (int j = target; j >= nums[i]; j --) {
                if (dp[j-nums[i]] || j==nums[i])
                    dp[j] = true;
            }
        }

        return dp[target];

    }
}