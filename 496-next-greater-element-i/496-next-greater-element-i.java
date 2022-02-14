class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int k = 0;
        for (int num : nums1) {
            int add = -1;
            for (int i = 0; i < nums2.length; i++) {
                if (num == nums2[i]) {
                    for (; i < nums2.length; i++) {
                        if (nums2[i] > num) {
                            add = nums2[i];
                            break;
                        }
                    }
                }
            }
            ans[k++] = add;
        }
        return ans;
    }
}