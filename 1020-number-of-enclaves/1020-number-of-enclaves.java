class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)) {
                    dfs(i, j, grid);
                }
            }
        }
        int count = 0;
        for (int[] r : grid) {
            for (int c : r) {
                if (c == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 0;

        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }
}