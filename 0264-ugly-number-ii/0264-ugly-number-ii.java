class Solution {
    public int nthUglyNumber(int n) {
         int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1; // The first ugly number is 1
        
        int index2 = 0, index3 = 0, index5 = 0; // Pointers for 2, 3, and 5
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        
        for (int i = 1; i < n; i++) {
            // Find the next ugly number
            int nextUgly = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUgly;
            
            // Increment the respective pointer
            if (nextUgly == nextMultipleOf2) {
                index2++;
                nextMultipleOf2 = uglyNumbers[index2] * 2;
            }
            if (nextUgly == nextMultipleOf3) {
                index3++;
                nextMultipleOf3 = uglyNumbers[index3] * 3;
            }
            if (nextUgly == nextMultipleOf5) {
                index5++;
                nextMultipleOf5 = uglyNumbers[index5] * 5;
            }
        }
        
        return uglyNumbers[n - 1]; // The n-th ugly number
    }
}
   