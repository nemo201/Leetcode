class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 0;
        int area = 1;

        area += dfs(r + 1, c, grid);
        area += dfs(r - 1, c, grid);
        area += dfs(r, c + 1, grid);
        area += dfs(r, c - 1, grid);
        
        return area;
    }
}