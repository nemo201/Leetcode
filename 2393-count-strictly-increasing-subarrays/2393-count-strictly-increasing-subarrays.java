class Solution {
    public long countSubarrays(int[] nums) {
        int start = 0, end = 1;
        long n = 0, res = 0;
        
        while (end < nums.length) {
            if (nums[end] <= nums[end - 1]) {
                n = end - start;
                res += (n * (n + 1)) / 2;
                start = end;
            }
            end++;
        }
        n = end - start;
        res += (n * (n + 1)) / 2;
        return res;
    }
}