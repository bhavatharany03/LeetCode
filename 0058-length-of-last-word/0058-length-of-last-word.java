class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        String[] starr = s.trim().split("\\s+");
        
        if(starr.length ==0){
            return 0;
        }

        String lastword = starr[starr.length - 1];
        return lastword.length();
    }
}