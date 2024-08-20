class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }
        
        int[][] dp = new int[n][n + 1];
        return dfs(piles, prefixSum, 0, 1, dp);
    }
    
    private int dfs(int[] piles, int[] prefixSum, int i, int m, int[][] dp) {
        int n = piles.length;
        if (m * 2 >= n - i) {
            return prefixSum[n] - prefixSum[i];
        }
        if (dp[i][m] != 0) {
            return dp[i][m];
        }
        
        int best = 0;
        for (int x = 1; x <= 2 * m; x++) {
            if (i + x <= n) {
                best = Math.max(best, prefixSum[n] - prefixSum[i] - dfs(piles, prefixSum, i + x, Math.max(m, x), dp));
            }
        }
        
        dp[i][m] = best;
        return best;
    }
}