class Solution {
    public int numMagicSquaresInside(int[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        
        int sum1 = grid[row][col] + grid[row][col+1] + grid[row][col+2];
        int sum2 = grid[row+1][col] + grid[row+1][col+1] + grid[row+1][col+2];
        int sum3 = grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2];

        int col1 = grid[row][col] + grid[row+1][col] + grid[row+2][col];
        int col2 = grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1];
        int col3 = grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2];

        int diag1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int diag2 = grid[row+2][col] + grid[row+1][col+1] + grid[row][col+2];

       
        return sum1 == 15 && sum2 == 15 && sum3 == 15 &&
               col1 == 15 && col2 == 15 && col3 == 15 &&
               diag1 == 15 && diag2 == 15;
    }
}