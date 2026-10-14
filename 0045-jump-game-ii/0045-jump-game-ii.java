class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int furEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            furEnd = Math.max(furEnd, i + nums[i]);

            if (i == curEnd) {
                jumps++;
                curEnd = furEnd;
            }
        }

        return jumps;
    }
}