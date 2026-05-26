class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canShip(int[] weights, int days, int k) {
        int usedDays = 1;
        int currentWeight = 0;
        for (int w : weights) {
            if (currentWeight + w > k) {
                usedDays++;
                currentWeight = 0;
            }
            currentWeight += w;
        }
        return usedDays <= days;
    }
}