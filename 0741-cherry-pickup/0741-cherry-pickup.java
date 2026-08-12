class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        int[][][] memo = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -2);
            }
        }

        int ans = helper(grid, 0, 0, 0, memo);

        return Math.max(0, ans);
    }

    private int helper(
        int[][] grid,
        int r1,
        int c1,
        int r2,
        int[][][] memo
    ) {
        int n = grid.length;

        // Calculate c2
        int c2 = r1 + c1 - r2;

        // Invalid state
        if (r1 >= n || c1 >= n ||
            r2 >= n || c2 >= n ||
            c1 < 0 || c2 < 0) {
            return -1;
        }

        // Hit a thorn
        if (grid[r1][c1] == -1 ||
            grid[r2][c2] == -1) {
            return -1;
        }

        // Already solved
        if (memo[r1][c1][r2] != -2) {
            return memo[r1][c1][r2];
        }

        // Reached destination
        if (r1 == n - 1 && c1 == n - 1) {
            return memo[r1][c1][r2] = grid[r1][c1];
        }

        // Collect cherries
        int cherries = grid[r1][c1];

        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        // Person 1: right
        // Person 2: right
        int rr = helper(
            grid,
            r1,
            c1 + 1,
            r2,
            memo
        );

        // Person 1: right
        // Person 2: down
        int rd = helper(
            grid,
            r1,
            c1 + 1,
            r2 + 1,
            memo
        );

        // Person 1: down
        // Person 2: right
        int dr = helper(
            grid,
            r1 + 1,
            c1,
            r2,
            memo
        );

        // Person 1: down
        // Person 2: down
        int dd = helper(
            grid,
            r1 + 1,
            c1,
            r2 + 1,
            memo
        );

        int best = Math.max(
            Math.max(rr, rd),
            Math.max(dr, dd)
        );

        if (best == -1) {
            return memo[r1][c1][r2] = -1;
        }

        return memo[r1][c1][r2] = cherries + best;
    }
}