class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adj.get(u).add(new double[]{v, prob});
            adj.get(v).add(new double[]{u, prob});
        }

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        Queue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        pq.offer(new double[]{1.0, start_node});

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            double prob = cur[0];
            int node = (int) cur[1];

            if (prob < maxProb[node]) {
                continue;
            }

            if (node == end_node) {
                return prob;
            }

            for (double[] nei : adj.get(node)) {
                int next = (int) nei[0];
                double edgeProb = nei[1];

                double newProb = prob * edgeProb;
                if (newProb > maxProb[next]) {
                    maxProb[next] = newProb;
                    pq.offer(new double[]{newProb, next});
                }
            }
        }
        return 0.0;
    }
}