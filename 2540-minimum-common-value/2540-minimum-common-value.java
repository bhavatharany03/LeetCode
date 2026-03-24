class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
    

      int start1 = 0;

       int start2 = 0;

      int len = nums1.length;
      int len2 = nums2.length;
       int res=0;

     while(start1<len && start2<len2){
        if(nums1[start1]==nums2[start2]){
            return  nums1[start1];
            
        }
        
        else if(nums1[start1]<nums2[start2]){
            start1++;
        }

        else{
           start2++; 
        }

     }

      return -1;
    }
}