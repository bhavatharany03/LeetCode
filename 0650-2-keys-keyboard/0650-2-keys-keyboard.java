class Solution {
    public int minSteps(int n) {
       if (n == 1) return 0;
        
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i; // worst case: need i operations (copy 1 and paste i-1 times)
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) { // i is divisible by j
                    dp[i] = dp[j] + (i / j);
                    break;
                }
            }
        }
        return dp[n];
    }
}  
   