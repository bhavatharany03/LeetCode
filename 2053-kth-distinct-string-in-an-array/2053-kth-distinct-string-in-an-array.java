class Solution {
    public String kthDistinct(String[] arr, int k) {
       List<String> ans = new ArrayList<>(); 

       HashMap<String,Integer> map = new HashMap<>();

       for(String str:arr){
        map.put(str, map.getOrDefault(str,0)+1);
       }

       for (String str : arr) {
            if (map.get(str) == 1) {
                ans.add(str);
            }
        }

       if(k>0 && k<= ans.size()){
        return ans.get(k-1);
       }

       return "";
    }
}