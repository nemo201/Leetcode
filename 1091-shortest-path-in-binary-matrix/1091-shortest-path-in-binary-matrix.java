class Solution {
    private static final int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            int dist = cell[2];
            
            if (row == grid.length - 1 && col == grid[0].length - 1)
                return dist;
            
            for (int[] nei : getNei(row, col, grid)) {
                int nRow = nei[0];
                int nCol = nei[1];
                
                if (visited[nRow][nCol])
                    continue;
                
                visited[nRow][nCol] = true;
                q.offer(new int[]{nRow, nCol, dist + 1});
            }
        }
        return -1;
    }
    
    private List<int[]> getNei(int row, int col, int[][] grid) {
        List<int[]> nei = new ArrayList<>();
        for (int i = 0; i < dir.length; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] != 0)
                continue;
            nei.add(new int[]{newRow, newCol});
        }
        return nei;
    }
}