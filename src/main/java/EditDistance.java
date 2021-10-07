class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0 || len2 == 0)
            return len1+len2;

        int[][] dp = new int[len1][len2];
        char ch1, ch2;

        for (int i = 0; i < len1; i ++) {
            for (int j = 0; j < len2; j ++) {
                ch1 = word1.charAt(i);
                ch2 = word2.charAt(j);
                if (i == 0 && j == 0) {
                    dp[0][0] = ( ch1 == ch2 ? 0 : 1 );
                } else if (i == 0) {
                    if (ch2 == word1.charAt(0))
                        dp[0][j] = j;
                    else
                        dp[0][j] = dp[0][j-1] + 1;
                } else if (j == 0) {
                    if (ch1 == word2.charAt(0))
                        dp[i][0] = i;
                    else
                        dp[i][0] = dp[i-1][0] + 1;
                } else {
                    if (ch1 == ch2)
                        dp[i][j] = dp[i-1][j-1];
                    else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]) + 1;
                    }
                }
            }
        }

        return dp[len1-1][len2-1];

    }
}
