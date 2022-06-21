class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReq = new HashMap<>();
        
        for (int i = 0 ; i < numCourses; i++) {
            preReq.put(i, new ArrayList());
        }
        
        for (int[] pre : prerequisites) {
            List<Integer> nei = preReq.get(pre[0]);
            nei.add(pre[1]);
            preReq.put(pre[0], nei);
        }
        
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        Stack<Integer> ordered = new Stack<>();
        boolean isCycle = false;
        
        for (int i = 0; i < numCourses; i++) {
            if (!isCycle && !visited.contains(i)) {
                isCycle = dfs(preReq, i, visited, visiting, ordered);
            }
        }
        
        if (isCycle)
            return new int[0];
        
        int[] res = new int[numCourses];
        
        for (int i = numCourses - 1; i >= 0; i--) {
            res[i] = ordered.pop();
        }
        return res;
    }
    
    public boolean dfs(Map<Integer, List<Integer>> preReq, int course, Set<Integer> visited, Set<Integer> visiting, Stack<Integer> ordered) {
        if (visiting.contains(course))
            return true;
        
        visiting.add(course);
        List<Integer> coursePre = preReq.get(course);
        boolean isCycle = false;
        
        for (int preCourse = 0; preCourse < coursePre.size(); preCourse++) {
            if (!isCycle)
                isCycle = dfs(preReq, coursePre.get(preCourse), visited, visiting, ordered);
        }
        
        if (!visited.contains(course))
            ordered.push(course);
        
        visiting.remove(course);
        visited.add(course);
        return isCycle;
    }
}