public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans = 0;

        for (int i = 0; i < len; i ++)
            for (int j = 0; j <= i; j ++)
                dp[i][j] = true;

        for (int d = 1; d < len; d ++) {
            for (int i = 0; i+d < len; i ++) {
                if (s.charAt(i) == s.charAt(i+d)) {
                    dp[i][i+d] = dp[i+1][i+d-1];
                    if (dp[i][i+d])
                        ans ++;
                }
            }
        }

        return ans+len;
    }
}