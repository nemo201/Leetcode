class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int left = map.get(nums[i]);
                ans[0] = i;
                ans[1] = left;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return ans;
    }
}