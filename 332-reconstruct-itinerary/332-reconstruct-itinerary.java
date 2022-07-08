class Solution {
    
    Map<String, List<String>> map = new HashMap<>();
        Map<String, boolean[]> visited = new HashMap<>();
        int flights = 0;
        List<String> ans = null;
    
    public List<String> findItinerary(List<List<String>> tickets) {
                
        for (List<String> str : tickets) {
            map.putIfAbsent(str.get(0), new ArrayList());
            map.get(str.get(0)).add(str.get(1));
        }
        
        for (Map.Entry<String, List<String>> entry : this.map.entrySet()) {
            Collections.sort(entry.getValue());
            this.visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        
        this.flights = tickets.size();
        List<String> route = new ArrayList();
        route.add("JFK");
        
        bt("JFK", route);
        return ans;
    }
    
    private boolean bt(String origin, List<String> route) {
        if (route.size() == flights + 1) {
            this.ans = new ArrayList(route);
            return true;
        }
        
        if (!map.containsKey(origin))
            return false;
        
        int i = 0;
        boolean[] bitmap = visited.get(origin);
        
        for (String dest : map.get(origin)) {
            if (!bitmap[i]) {
                bitmap[i] = true;
                route.add(dest);
                boolean ret = bt(dest, route);
                bitmap[i] = false;
                route.remove(route.size() - 1);
                
                if (ret)
                    return true;
            }
            i++;
        }
        return false;
    }
}