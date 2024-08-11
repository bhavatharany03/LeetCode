class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int minDays(int[][] grid) {
         if (!isConnected(grid)) {
            return 0; 
        }

        int rows = grid.length;
        int cols = grid[0].length;

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0; 
                    if (!isConnected(grid)) {
                        return 1; 
                    }
                    grid[i][j] = 1; 
                }
            }
        }

        
        return 2;
    }
    
    private boolean isConnected(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int landCells = 0;
        int[] start = new int[2];
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    landCells++;
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        if (landCells == 0) return false; 
        
        
        int connectedLandCells = dfs(grid, visited, start[0], start[1]);
        
        
        return connectedLandCells == landCells;
    }
    
    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || visited[x][y]) {
            return 0;
        }
        
        visited[x][y] = true;
        int connectedCells = 1; 
        
        
        for (int[] dir : directions) {
            connectedCells += dfs(grid, visited, x + dir[0], y + dir[1]);
        }
        
        return connectedCells;
    }
}
        
    