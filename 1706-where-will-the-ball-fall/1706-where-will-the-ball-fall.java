class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        
        for (int col = 0; col < grid[0].length; col++) {
            int curCol = col;
            for (int row = 0; row < grid.length; row++) {
                int nextCol = curCol + grid[row][curCol];
                if (nextCol < 0 || nextCol > grid[0].length - 1 || grid[row][curCol] != grid[row][nextCol]) {
                    result[col] = -1;
                    break;
                }
                result[col] = nextCol;
                curCol = nextCol;
            }
        }
        return result;
    }
}