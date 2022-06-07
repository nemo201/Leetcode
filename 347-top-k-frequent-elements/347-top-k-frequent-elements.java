class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if (k == nums.length)
            return nums;
        
        Map<Integer, Integer> map = new HashMap<>();
        int []ans = new int [k];
        int f = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else
                map.put(n, 1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>(
        (n1, n2) -> map.get(n1) - map.get(n2));
        
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll();
        }
        
        return ans;
    }
}