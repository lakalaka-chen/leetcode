public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < len; i ++) {
            dp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}