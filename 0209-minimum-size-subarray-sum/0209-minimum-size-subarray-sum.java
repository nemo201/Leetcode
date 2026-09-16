class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int minlen = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minlen = Math.min(minlen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}