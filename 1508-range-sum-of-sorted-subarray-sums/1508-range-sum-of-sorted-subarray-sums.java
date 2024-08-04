class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int m=n*(n+1)/2;
        int M_O_D = 1_000_000_007;
        ArrayList<Integer> prefixsum = new ArrayList<>();

        
        for(int i=0;i<n;i++){
            int sum=0;

            for(int j=i;j<n;j++){
                sum+=nums[j];
                prefixsum.add(sum);
            }
        }


        Collections.sort(prefixsum);

        int ans=0;
        
        for(int i=left-1;i<right;i++){
            ans = (ans + prefixsum.get(i)) % M_O_D;
        }
        return ans;

    }


}