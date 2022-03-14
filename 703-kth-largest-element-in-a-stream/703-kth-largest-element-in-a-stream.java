class KthLargest {
    Queue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums)
            add(num);
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k)
            minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */