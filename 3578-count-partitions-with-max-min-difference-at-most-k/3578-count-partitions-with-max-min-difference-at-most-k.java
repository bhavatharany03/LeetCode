class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            // Maintain sliding max deque
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right])
                maxQ.pollLast();
            maxQ.addLast(right);

            // Maintain sliding min deque
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right])
                minQ.pollLast();
            minQ.addLast(right);

            // Shrink window until valid
            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                left++;
                if (maxQ.peekFirst() < left) maxQ.pollFirst();
                if (minQ.peekFirst() < left) minQ.pollFirst();
            }

            // dp index uses right+1 because dp[i] means first i elements
            int L = left;        // inclusive
            int R = right;       // inclusive

            // dp[R+1] = prefix[R] - prefix[L-1]
            long sum = prefix[R];
            if (L - 1 >= 0)
                sum = (sum - prefix[L - 1] + MOD) % MOD;

            dp[R + 1] = sum;
            prefix[R + 1] = (prefix[R] + dp[R + 1]) % MOD;
        }

        return (int) dp[n];
       
    }
}