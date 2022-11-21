class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length, steps = 0;
        Queue<int[]> q = new LinkedList();
        boolean visited[][] = new boolean[rows][cols];
        int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        q.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        
        while (!q.isEmpty()) {
            int qsize = q.size();
            steps++;
            
            for (int i = 0; i < qsize; i++) {
                int cur[] = q.poll();
                
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    
                    if (x < 0 || x >= rows || y < 0 || y >= cols)
                        continue;
                    
                    if (visited[x][y] || maze[x][y] == '+')
                        continue;
                    
                    if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1)
                        return steps;
                    
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }
}