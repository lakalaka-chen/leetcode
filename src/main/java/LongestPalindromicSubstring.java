public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int ans_i = 0, ans_j = 0;
        int maxlen = 0;
        boolean[][] dp = new boolean[len][len];
        // dp[i][j]==false表示s[i:j]是回文子串
        // false表示回文子串是为了省去初始化的时间
        for (int d = 1; d < len; d ++) {
            for (int i = 0; i+d < len; i ++) {
                if (s.charAt(i) == s.charAt(i+d)) {
                    dp[i][i+d] = dp[i+1][i+d-1];
                } else {
                    dp[i][i+d] = true;
                }
                if (dp[i][i+d] == false && maxlen < d) {
                    ans_i = i;
                    ans_j = i+d;
                    maxlen = d;
                }
            }
        }
        return s.substring(ans_i, ans_j+1);
    }
}
