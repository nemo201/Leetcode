class Solution {
    public int maxOperations(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) > 0) {
                map.put(k - num, map.get(k - num) - 1);
                res++;
            } else {
                map.put(num, 1 + map.getOrDefault(num, 0));
            }
        }
        return res;
    }
}