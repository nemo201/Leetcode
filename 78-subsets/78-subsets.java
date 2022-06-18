class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int n , k;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length; 
        for (k = 0; k < n + 1; k++) {
            backTrack(0, new ArrayList<>(), nums);
        }
        return list;
    }
    
    public void backTrack(int index, List<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            list.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = index; i < n; i++) {
            curr.add(nums[i]);
            backTrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}