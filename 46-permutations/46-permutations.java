class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean []freq = new boolean[nums.length];
        findPrem(nums, list, new ArrayList<>(), freq);
        return list;
    }
    
    public void findPrem(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean []freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                findPrem(nums, ans, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}