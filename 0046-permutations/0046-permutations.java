class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper (nums, used, lists, new ArrayList<>());
        return lists;
    }

    private void helper (int[] nums, boolean[] used, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            list.add(nums[i]);

            helper (nums, used, lists, list);
            list.remove(list.size() - 1);

            used[i] = false;
        }
    }
}