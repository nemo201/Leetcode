class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;

        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }

        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int n : nums) {
            if (currentSum + n > maxSum) {
                currentSum = 0;
                subarrays++;
            }
            currentSum += n;
        }

        return subarrays <= k;
    }
}