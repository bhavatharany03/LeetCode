class Solution {
    public int[] plusOne(int[] digits) {
        int last = digits.length;

        for(int i=last-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }

           
         digits[i]=0;
        }

      

        int[] ans = new int[last+1];

        ans[0]=1;
        ans[1]=0;
        return ans;
    }
}

