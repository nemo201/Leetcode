class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                ans = i;
                return ans;
            }
        }
        return nums.length;
    }
}