class Solution {
    public void sortColors(int[] nums) {
        
        int start1 = 0;
        int start2 = 1;

        int end = nums.length;  

        while(start2<end){

            if(nums[start1]>nums[start2]){
                int temp = nums[start1];
                nums[start1]=nums[start2];
                nums[start2]=temp;

                start1=0;
                start2=1;
            }
            else{
            start1++;
            start2++;
            }
        }

    }
}