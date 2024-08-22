class Solution {
    public int findComplement(int num) {
       int bitLength = Integer.toBinaryString(num).length();
        
        // Create a mask with all bits set to 1 with the same length as num
        int mask = (1 << bitLength) - 1;
        
        // XOR num with mask to get the complement
        return num ^ mask; 
    }
}