class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
     int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // Check if out of bounds or at a water cell
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0) {
            return true;
        }

        // If the current land in grid2 is not a land in grid1, it's not a sub-island
        if (grid1[i][j] == 0) {
            return false;
        }

        // Mark the cell as visited
        grid2[i][j] = 0;

        // Perform DFS on all 4 directions
        boolean isSubIsland = true;
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);

        return isSubIsland;
    }
}   
   