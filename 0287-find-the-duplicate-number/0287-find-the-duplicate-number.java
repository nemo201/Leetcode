class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i != n + 1) {
            int temp = i;
            int previous_i = nums[temp];
            i = nums[i];
            nums[temp] = n + 1;

            if (nums[i] == n + 1){
                return previous_i;
            }
        }
        return 0;
    }
}