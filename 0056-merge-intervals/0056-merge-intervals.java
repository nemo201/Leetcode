class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new LinkedList<>();

        for (int[] i : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < i[0]) {
                ans.add(i);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], i[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}