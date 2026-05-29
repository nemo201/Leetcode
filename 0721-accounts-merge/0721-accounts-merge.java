class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int m = accounts.get(i).size();

            for (int j = 1; j < m; j++) {
                String e = accounts.get(i).get(j);

                if (!map.containsKey(e)) {
                    map.put(e, i);
                } else {
                    uf.union(i, map.get(e));
                }
            }
        }
        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : map.keySet()) {
            int group = map.get(email);
            int groupRep = uf.find(group);

            if (!components.containsKey(groupRep)) {
                components.put(groupRep, new ArrayList<>());
            }
            components.get(groupRep).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> component = components.get(group);
            Collections.sort(component);
            component.add(0, accounts.get(group).get(0));
            ans.add(component);
        }
        return ans;
    }

    class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return;
            }

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }
        }
    }
}