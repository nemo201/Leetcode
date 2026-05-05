class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            if (cur < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(cur, maxSoFar * cur);
            minSoFar = Math.min(cur, minSoFar * cur);

            max = Math.max(max, maxSoFar);
        }

        return max;
    }
}