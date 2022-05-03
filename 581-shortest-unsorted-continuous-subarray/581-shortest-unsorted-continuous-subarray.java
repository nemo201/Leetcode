class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] snum = nums.clone();
        Arrays.sort(snum);
        int start = snum.length, end = 0;
        for (int i = 0; i < snum.length; i++) {
            if (snum[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}