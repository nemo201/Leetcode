class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0, sum = 0, ans = 0;
            while (left < nums.length && right < nums.length) {
                if (!set.contains(nums[right])) {
                    set.add(nums[right]);
                    sum += nums[right];
                    ans = Math.max(ans, sum);
                    right++;
                } else {
                    set.remove(nums[left]);
                    sum -= nums[left];
                    left++;
                }
            }
        return ans;
    }
}