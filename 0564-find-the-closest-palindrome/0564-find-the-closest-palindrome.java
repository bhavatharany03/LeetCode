class Solution {
    public String nearestPalindromic(String n) {
          int len = n.length();
        long num = Long.parseLong(n);

        // Edge cases
        long smaller = (long) Math.pow(10, len - 1) - 1; // Example: 99...99
        long larger = (long) Math.pow(10, len) + 1;      // Example: 100...001

        // Get the first half of the number to generate possible palindromes
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        // Generate potential palindromes
        long[] candidates = new long[]{
            mirror(prefix - 1, len),  // Smaller prefix
            mirror(prefix, len),      // Same prefix
            mirror(prefix + 1, len),  // Larger prefix
            smaller,                  // 99...99 (edge case)
            larger                    // 100...001 (edge case)
        };

        long closest = -1;
        for (long candidate : candidates) {
            if (candidate != num) {
                if (closest == -1 || Math.abs(candidate - num) < Math.abs(closest - num) ||
                    (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)) {
                    closest = candidate;
                }
            }
        }

        return String.valueOf(closest);
    }

    private long mirror(long prefix, int len) {
        String prefixStr = String.valueOf(prefix);
        StringBuilder sb = new StringBuilder(prefixStr);
        String palindrome = prefixStr + sb.reverse().substring(len % 2);
        return Long.parseLong(palindrome);
    }
}