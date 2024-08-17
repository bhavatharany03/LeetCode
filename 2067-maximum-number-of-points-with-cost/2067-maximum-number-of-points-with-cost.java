class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[] prev = new long[n];
        long[] curr = new long[n];

        // Initialize prev array with the first row
        for (int j = 0; j < n; j++) {
            prev[j] = points[0][j];
        }

        // Iterate through each row
        for (int i = 1; i < m; i++) {
            // Compute left max values
            long[] left = new long[n];
            left[0] = prev[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1] - 1, prev[j]);
            }

            // Compute right max values
            long[] right = new long[n];
            right[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, prev[j]);
            }

            // Compute the current row max values
            for (int j = 0; j < n; j++) {
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            // Move to the next row
            System.arraycopy(curr, 0, prev, 0, n);
        }

        // Find the maximum value in the last row
        long result = 0;
        for (int j = 0; j < n; j++) {
            result = Math.max(result, prev[j]);
        }

        return result;
    }
}
