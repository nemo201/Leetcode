class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int n, k;
    
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; k++) {
            backTrack(0, new ArrayList(), nums);
        }
        return list;
    }
    
    public void backTrack(int index, List<Integer> ds, int[] nums) {
        if (index == k) {
            list.add(new ArrayList(ds));
            return;
        }
        
        for (int i = index; i < n; i++) {
            ds.add(nums[i]);
            backTrack(i + 1, ds, nums);
            ds.remove(ds.size() - 1);
        }
    }
}