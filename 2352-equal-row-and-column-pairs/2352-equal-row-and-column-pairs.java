class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> rowMap = new HashMap<>();

        
        for (int[] row : grid) {
            String rowPattern = Arrays.toString(row);
            rowMap.put(rowPattern, rowMap.getOrDefault(rowPattern, 0) + 1);
        }

        int count = 0;

        
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String colPattern = Arrays.toString(col);
            if (rowMap.containsKey(colPattern)) {
                count += rowMap.get(colPattern);
            }
        }

        return count;
    }
}