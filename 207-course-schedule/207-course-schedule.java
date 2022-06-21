class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visitSet = new HashSet<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList());
        }
        
        for (int[] pre : prerequisites) {
            List<Integer> neighbors = preMap.get(pre[0]);
            neighbors.add(pre[1]);
            preMap.put(pre[0], neighbors);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preMap, visitSet))
                return false;
        }
        
        return true;
    }
    
    public boolean dfs(int course,  Map<Integer, List<Integer>> preMap, Set<Integer> visitSet) {
        if (visitSet.contains(course))
            return false;
        
        if (preMap.get(course).size() == 0)
            return true;
        
        visitSet.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(pre, preMap, visitSet))
                return false;
        }
        visitSet.remove(course);
        preMap.put(course, new ArrayList());
        return true;
    }
}