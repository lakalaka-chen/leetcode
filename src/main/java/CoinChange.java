public class CoinChange {

    // 无法交换的情况设置为Integer.MAX_VALUE-1是为了防止 dp[i][j-coins[i-1]+1上溢出
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];

        for (int j = 0; j <= amount; j ++) dp[0][j] = Integer.MAX_VALUE-1;
        for (int i = 0; i <= len; i ++) dp[i][0] = 0;

        for (int j = 1; j <= amount; j ++)
            if (j % coins[0] == 0)
                dp[1][j] = j/coins[0];
            else
                dp[1][j] = Integer.MAX_VALUE-1;

        for (int i = 1; i <= len; i ++) {
            for (int j = 1; j <= amount; j ++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1])
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i-1]]+1);
            }
        }

        return dp[len][amount] == Integer.MAX_VALUE-1 ? -1 : dp[len][amount];
    }
}
