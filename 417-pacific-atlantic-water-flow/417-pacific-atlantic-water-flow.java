class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        int[] dy= new int[]{1, -1, 0, 0};
        int[] dx= new int[]{0, 0, 1, -1};
        for (int i = 0; i < m; i++) {
            explore(pacific, heights, i, 0, m, n, dx, dy);
            explore(atlantic, heights, i, n - 1, m, n, dx, dy);
        }
        
        for (int j = 0; j < n; j++) {
            explore(pacific, heights, 0, j, m, n, dx, dy);
            explore(atlantic, heights, m - 1, j, m, n, dx, dy);
        }
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    solution.add(new ArrayList<Integer>(Arrays.asList(i, j)));
            }
        }
        return solution;
    }
    
    public void explore(boolean[][] ocean, int[][] heights, int r, int c, int m, int n, int[] dx, int[] dy) {
        ocean[r][c] = true;
        for (int i = 0; i < 4; i++) {
            if (r + dx[i] >= 0 && r + dx[i] < m && c + dy[i] >= 0 && c + dy[i] < n
               && !ocean[r + dx[i]][c + dy[i]] && heights[r + dx[i]][c + dy[i]] >= heights[r][c] ) 
                explore(ocean, heights, r + dx[i], c + dy[i], m, n, dx, dy);
        }
    }
}