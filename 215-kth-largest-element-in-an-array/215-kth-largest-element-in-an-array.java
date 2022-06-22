class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        
        for (int num : nums)
            heap.offer(num);
        
        while (heap.size() > k)
            heap.poll();
        
        return heap.peek();
    }
}