public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1]; // dp[i]表示nums[0:i-1]乘积
        dp[0] = 1;
        for (int i = 1; i <= len; i ++)
            dp[i] = dp[i-1]*nums[i-1];
        int[] dp2 = new int[len]; // dp[i]表示nums[i+1:]乘积
        dp2[len-1] = 1;
        for (int i = len-2; i >= 0; i --)
            dp2[i] = dp2[i+1]*nums[i+1];
        int[] result = new int[len];
        for (int i = 0; i < len; i++)
            result[i] = dp[i] * dp2[i];
        return result;
    }
}