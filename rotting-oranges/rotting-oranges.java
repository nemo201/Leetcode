class Solution {
    private static final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        
        int rows = grid.length, cols = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2)
                    q.offer(new int[]{r, c});
                if (grid[r][c] == 1)
                    fresh++;
            }
        }
        q.offer(new int[]{-1, -1});
        int mins = -1;
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            
            if (row == -1) {
                mins++;
                
                if(!q.isEmpty())
                    q.offer(new int[]{-1, -1});
            } else {
                for (int[] nei : getNei(row, col, grid)) {
                    int nRow = nei[0];
                    int nCol = nei[1];
                    
                    if (grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2;
                        fresh--;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
        }
        return fresh == 0 ? mins : -1;
    }
    
    private List<int[]> getNei(int row, int col, int[][] grid) {
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < dir.length; i++) {
            int newR = row + dir[i][0];
            int newC = col + dir[i][1];
            
            if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length)
                continue;
            list.add(new int[]{newR, newC});
        }
        return list;
    }
}