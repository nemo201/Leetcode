class Solution {
    int r, c;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        r = heights.length;
        c = heights[0].length;

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        for (int i = 0; i < c; i++) {
            dfs(0, i, pacific, heights);
            dfs(r - 1, i, atlantic, heights);
        }

        for (int j = 0; j < r; j++) {
            dfs(j, 0, pacific, heights);
            dfs(j, c - 1, atlantic, heights);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, boolean[][] visited, int[][] heights) {
        visited[i][j] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];

            if (nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && heights[nr][nc] >= heights[i][j]) {
                dfs(nr, nc, visited, heights);
            }
        }
    }
}