class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        

        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        
        int n=0;
        for(int key:map.keySet()){
            if(map.get(key)>1){
                 n = key;
                
            }
        }
        
        return n;
            }
}