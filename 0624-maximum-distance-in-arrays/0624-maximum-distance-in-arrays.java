class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        // Iterate through the arrays starting from the second one
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);

            // Calculate potential max distances using the current array's first and last elements
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);
            
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));

            // Update the global minimum and maximum
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDistance;
    }
}


   