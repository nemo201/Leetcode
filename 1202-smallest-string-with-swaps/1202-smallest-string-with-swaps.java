class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        
        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int dest = edge.get(1);
            
            uf.union(source, dest);
        }
        
        Map<Integer, List<Integer>> dic = new HashMap<>();
        
        for (int v = 0; v < s.length(); v++) {
            int root = uf.find(v);
            dic.putIfAbsent(root, new ArrayList<>());
            dic.get(root).add(v);
        }
        
        char[] smolStr = new char[s.length()];
        
        for (List<Integer> list : dic.values()) {
            List<Character> characters = new ArrayList();
            for (int index : list) {
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);
            
            for (int index = 0; index < list.size(); index++) {
                smolStr[list.get(index)] = characters.get(index);
            }
        }
        
        return new String(smolStr);
    }
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            
            if (rx != ry) {
                if (rank[rx] > rank[ry])
                    root[ry] = rx;
                else if (rank[rx] < rank[ry])
                    root[rx] = ry;
                else {
                    root[ry] = rx;
                    rank[rx]++;
                }
            }
        }
    }
}