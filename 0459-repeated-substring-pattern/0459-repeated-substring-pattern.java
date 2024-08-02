class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String fake = s+s;
        return fake.substring(1,fake.length()-1).contains(s);
    }
}