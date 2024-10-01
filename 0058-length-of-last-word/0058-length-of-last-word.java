class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.trim().split(" ");
        String last = arr[arr.length-1];
        return last.length();
    }
}