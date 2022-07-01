class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        
        for (int[] inter : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < inter[0])
                ans.add(inter);
            else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], inter[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}