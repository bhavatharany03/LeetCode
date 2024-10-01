class Solution {
    public boolean isAnagram(String s, String t) {
        HashSet<Character> set = new HashSet<>();
        if(s.length()==t.length()){
            for(char ch:s.toCharArray()){
                set.add(ch);
            }
        }
        HashSet<Character> map = new HashSet<>();
        for(char ch:t.toCharArray()){
            map.add(ch);
        }
        if(set.equals(map)){
            return true;
        }
        return false;
    }
}