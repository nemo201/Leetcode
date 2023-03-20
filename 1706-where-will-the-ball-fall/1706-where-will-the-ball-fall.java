class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        Integer memo[][] = new Integer[grid.length + 1][grid[0].length];
        
        for (int row = grid.length; row >= 0; row--) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == grid.length) {
                    memo[row][col] = col;
                    continue;
                }
                int nextCol = col + grid[row][col];
                if (nextCol < 0 || nextCol > grid[0].length - 1 || grid[row][col] != grid[row][nextCol])
                    memo[row][col] = -1;
                else
                    memo[row][col] = memo[row + 1][nextCol];
                if (row == 0)
                    result[col] = memo[row][col];
            }
        }
        return result;
    }
}