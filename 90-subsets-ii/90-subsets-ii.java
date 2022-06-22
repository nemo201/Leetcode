class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        findSub(0, nums, list, new ArrayList());
        return list;
    }
    
    public void findSub(int index, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList(ds));
        
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            
            ds.add(nums[i]);
            findSub(i + 1, nums, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}