class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int i = m - 1;  // Pointer for nums1 (end of valid elements)
        int j = n - 1;  // Pointer for nums2
        int k = m + n - 1;  // Pointer for the final merged array (end of nums1)

        // Merge from the back to the front
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];  // Put larger element in the last position
            } else {
                nums1[k--] = nums2[j--];  // Put nums2[j] if it's larger
            }
        }

        // If there are remaining elements in nums2, copy them over
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
