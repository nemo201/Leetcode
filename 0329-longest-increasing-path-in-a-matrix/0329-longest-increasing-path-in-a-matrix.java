class Solution {
    int m, n;
    int[][] memo;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length; 
        n = matrix[0].length;
        memo = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }
        return ans;
    }

    private int dfs (int r, int c, int[][] matrix) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int best = 1;

        for (int[] dir : dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best, 1 + dfs(nr, nc, matrix));
            }
        }

        memo[r][c] = best;
        return best;
    }
}