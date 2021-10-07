import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();

        boolean[][] dp = new boolean[len+1][len+1];


        for (int d = 1; d <= len; d ++) {
            for (int i = 0; i < len; i ++) {
                for (int j = i+d; j <= len; j ++) {
                    if (wordDict.indexOf(s.substring(i, j)) != -1) {
                        dp[i][j] = true;
                        continue;
                    }
                    for (int k = i+1; k < j; k ++) {
                        if (dp[i][k] && dp[k][j]) {
                            dp[i][j] = true;
                            continue;
                        }
                    }
                }
            }
        }

        return dp[0][len];
    }
}