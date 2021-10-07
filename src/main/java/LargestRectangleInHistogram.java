class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[][] dp = new int[n][n];

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            dp[i][i] = i;
            result = Math.max(result, heights[i]);
        }

        for (int i = 0; i < n; i ++) {
            for (int j = i+1; j < n; j ++) {
                if (heights[j] < heights[ dp[i][j-1] ] ) {
                    dp[i][j] = j;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
                result = Math.max( result, (j-i+1)*heights[dp[i][j]] );
            }
        }

        return result;

    }
}
