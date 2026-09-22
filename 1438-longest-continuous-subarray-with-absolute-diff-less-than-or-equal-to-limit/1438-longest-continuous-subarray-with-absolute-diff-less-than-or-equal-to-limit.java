class Solution {
    public int longestSubarray(int[] nums, int limit) {

        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        ArrayDeque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int maxLen = 0;

         for (int right = 0; right < nums.length; right++) {

            // Maintain decreasing deque for maximum
            while (!maxDeque.isEmpty()
                    && nums[maxDeque.peekLast()] < nums[right]) {

                maxDeque.pollLast();
            }

            maxDeque.offerLast(right);

            // Maintain increasing deque for minimum
            while (!minDeque.isEmpty()
                    && nums[minDeque.peekLast()] > nums[right]) {

                minDeque.pollLast();
            }

            minDeque.offerLast(right);

            // Window is invalid
            while (nums[maxDeque.peekFirst()]
                    - nums[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}