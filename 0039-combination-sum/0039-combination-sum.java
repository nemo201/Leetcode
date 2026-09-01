class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper (candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private void helper (int[] can, int target, int index, List<List<Integer>> ans, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < can.length; i++) {
            if (can[i] > target) {
                break;
            }
            list.add(can[i]);
            helper (can, target - can[i], i, ans, list);
            list.remove(list.size() - 1);
        }
    }
}