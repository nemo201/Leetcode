class Solution {
    Set<List<Integer>> set = new HashSet<>();
    int n, k;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        for (k = 0; k < n + 1; k++) {
            backTrack(0, new ArrayList(), nums);
        }
        return new ArrayList(set);
    }
    
    public void backTrack(int index, List<Integer> ds, int[] nums) {
        if (index == k) {
            set.add(new ArrayList(ds));
            return;
        }
        
        for (int i = index; i < n; i++) {
            ds.add(nums[i]);
            backTrack(i + 1, ds, nums);
            ds.remove(ds.size() - 1);
        }
    }
}
