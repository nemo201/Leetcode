class Solution {
    public int longestConsecutive(int[] nums) {
        Set <Integer> set = new HashSet<>();
        int longest = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int clongest = 1;
                int cNum = num;

                while (set.contains(cNum + 1)) {
                    clongest++;
                    cNum++;
                }

                longest = Math.max(clongest, longest);
            }
        }
        return longest;
    }
}