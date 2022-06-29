class Solution {
    public int jump(int[] nums) {
        int jump = 0, left = 0, right = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            right = Math.max(right, i + nums[i]);
            if (i == left) {
                jump++;
                left = right;
                
                if (left >= nums.length - 1)
                    break;
            }
        }
        return jump;
    }
}