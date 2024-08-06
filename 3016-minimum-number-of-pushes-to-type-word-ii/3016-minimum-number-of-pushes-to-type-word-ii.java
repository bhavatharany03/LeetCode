class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : word.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }

            else{
                map.put(ch,1);
            }
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.addAll(map.values());
        int index = 0;
        int ans =0;

        while(!pq.isEmpty()){

            ans += (index/8+1)*pq.poll();
            index++;

        }

        return ans;

    }
}