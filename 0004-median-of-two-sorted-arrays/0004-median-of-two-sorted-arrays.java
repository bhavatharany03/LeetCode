import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] res = new int[nums1.length + nums2.length];

        System.arraycopy(nums1,0,res,0,nums1.length);
        System.arraycopy(nums2,0,res,nums1.length,nums2.length);

        Arrays.sort(res);

        double output = 0.0;


        int n = res.length;

        if(n%2==0){
           output =  (res[n/2] + res[(n/2) - 1]) / 2.0;
        }

        else{
            output = res[n/2]; 
        }

     return output;
    }
}