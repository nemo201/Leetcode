class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int cmp = target - nums[i];
            if(map.containsKey(cmp))
                return new int[] {map.get(cmp), i};
            map.put(nums[i], i);
        }
        return null;
    }
}