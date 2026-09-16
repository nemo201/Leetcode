class Solution {
    public int findMaxLength(int[] nums) {
        int balance = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                balance++;
            } else {
                balance--;
            }

            if (map.containsKey(balance)) {
                max = Math.max(max, i - map.get(balance));
            } else {
                map.put(balance, i);
            }
        }
        return max;
    }
}