class Solution {
    public int maxProduct(int[] nums) {
        int minSofar = nums[0];
        int maxSofar = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            if (cur < 0) {
                int temp = maxSofar;
                maxSofar = minSofar;
                minSofar = temp;
            }

            maxSofar = Math.max(nums[i], cur * maxSofar);
            minSofar = Math.min(nums[i], cur * minSofar);

            max = Math.max(max, maxSofar);
        }
        return max;
    }
}