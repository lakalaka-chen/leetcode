public class HouseRobber {

    public int rob(int[] nums) {

        int len = nums.length;

        if (len == 1)   return nums[0];
        if (len == 2)   return Math.max(nums[0], nums[1]);

        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i ++)
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        // dp[i-1]可能抢劫了nums[i-1]，也可能没有抢劫nums[i-1]
        // dp[i-2]一定没有抢劫nums[i-1]，所以计算dp[i]是一定可以用dp[i-2]+nums[i]
        // 如果dp[i-1]抢劫了nums[i-1]，dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        // 如果dp[i-1]没有抢劫nums[i-1]，则dp[i-1]和dp[i-2]是相等的，上式仍然成立

        return dp[len-1];

    }
}
