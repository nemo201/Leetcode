class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        helper (nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    private void helper (int[] nums, int start, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            helper (nums, i + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }
}