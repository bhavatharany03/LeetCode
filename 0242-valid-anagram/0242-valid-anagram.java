class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> set = new HashMap<>();
        if(s.length()==t.length()){
            for(char ch:s.toCharArray()){
                set.put(ch,set.getOrDefault(ch,0)+1);
            }
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        if(set.equals(map)){
            return true;
        }
        return false;
    }
}