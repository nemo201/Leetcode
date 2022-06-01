class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0, i = 0;
        for (int num : nums) {
            sum += num;
            ans[i] = sum;
            i++;
        }
        return ans;
    }
}