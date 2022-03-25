class Solution {
    int[] directions = new int[] {0, 1, 0, -1, 0};
    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)
                    fill(grid, i, j);
            }
        }
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    fill(grid, i, j);
                }
            }
        }
        return res;
    }
    
    void fill(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1)
            return;
        grid[x][y] = 1;
        for (int i = 0; i < directions.length - 1; i++)
            fill(grid, x + directions[i], y + directions[i + 1]);
    }
}