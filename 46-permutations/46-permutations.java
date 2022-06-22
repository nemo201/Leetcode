class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        findP(0, nums, list);
        return list;
    }
    
    private void findP(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            findP(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }
    
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> list = new ArrayList<>();
//         boolean[] visited = new boolean[nums.length];
//         findP(nums, list, new ArrayList(), visited);
//         return list;
//     }
    
//     private void findP(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] visited) {
//         if (ds.size() == nums.length) {
//             ans.add(new ArrayList(ds));
//             return;
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//             if (!visited[i]) {
//                 visited[i] = true;
//                 ds.add(nums[i]);
//                 findP(nums, ans, ds, visited);
//                 ds.remove(ds.size() - 1);
//                 visited[i] = false;
//             }
//         }
//     }
// }