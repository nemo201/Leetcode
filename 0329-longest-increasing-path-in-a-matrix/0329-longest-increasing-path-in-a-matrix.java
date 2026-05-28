class Solution {
    int rows, cols;
    int[][] memo;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;

        memo = new int[rows][cols];

        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int r, int c) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int best = 1;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best, 1 + dfs(matrix, nr, nc));
            }
        }
        memo[r][c] = best;
        return best;
    }
}