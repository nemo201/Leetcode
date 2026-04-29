class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        int p1 = 0;

        for (int p2 = 1; p2 < n; p2++) {
            if (nums[p2] != nums[p1]) {
                p1++;
                nums[p1] = nums[p2];
            }
        }
        return p1 + 1;
    }
}