class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        helper (nums, 0, lists, new ArrayList());
        return lists;
    }

    private void helper (int[] nums, int start, List<List<Integer>> lists, List<Integer> list) {
        lists.add(new ArrayList(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper (nums, i + 1, lists, list);
            list.remove(list.size() - 1);
        }
    }
}