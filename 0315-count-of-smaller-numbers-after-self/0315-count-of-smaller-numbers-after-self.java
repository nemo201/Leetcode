class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();

        int r = 1;

        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }

        int[] tree = new int[r];

        Integer[] result = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            int currentRank = rank.get(nums[i]);

            result[i] = query(tree, currentRank - 1);
            update(tree, currentRank);
        }

        return Arrays.asList(result);
    }

    private int query(int[] tree, int index) {
        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }

    private void update(int[] tree, int index) {
        while (index < tree.length) {
            tree[index]++;
            index += index & -index;
        }
    }
}