class Solution {

int rows = 0;
int cols = 0;

int [][] heightsGlobal = null;

public List<List<Integer>> pacificAtlantic(int[][] heights) {
    heightsGlobal = heights;
    rows = heights.length;
    cols = heights[0].length;

    Set<String> po = new HashSet<>();
    Set<String> alt = new HashSet<>();
            
    for(int i = 0; i < cols; i++){
        //po cols
        dfs(0,i, po, heights[0][i]);
        //alt cols
        dfs(rows-1,i, alt, heights[rows-1][i]);
    }
    
    for(int j = 0; j<rows; j++){
        //po rows
        dfs(j,0, po, heights[j][0]);
        //alt cols
        dfs(j,cols-1, alt, heights[j][cols-1]);
    }
    
    List<List<Integer>> result = new ArrayList<>();
    
    for(int k = 0; k<rows; k++){
        for(int l = 0; l<cols; l++){
           String cell = Integer.toString(k) + ":" + Integer.toString(l);
            
            if(po.contains(cell) && alt.contains(cell)){
                String [] res = cell.split(":");
                
                List<Integer> resList = new ArrayList<>();
                resList.add(Integer.valueOf(res[0]));
                resList.add(Integer.valueOf(res[1]));
                result.add(resList);
            }
        }
    }
    
    return result;
    
}

public void dfs(int r, int c, Set<String> visited, int prevHeight) {
    String cell = Integer.toString(r) + ":" + Integer.toString(c);
    System.out.println(cell);
    if(visited.contains(cell) || r < 0 || r == rows || c < 0 || c == cols || heightsGlobal[r][c] < prevHeight){
        return;
    }
    
    visited.add(Integer.toString(r) + ":" + Integer.toString(c));
    
    dfs(r+1,c,visited, heightsGlobal[r][c]);
    dfs(r-1,c,visited, heightsGlobal[r][c]);
    dfs(r,c+1,visited, heightsGlobal[r][c]);
    dfs(r,c-1,visited, heightsGlobal[r][c]);
}
}