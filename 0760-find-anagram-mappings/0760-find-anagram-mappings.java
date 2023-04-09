class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) 
            map.put(nums2[i], i);
        
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}