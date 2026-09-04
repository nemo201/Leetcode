class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int result = 0, left = -1, right = -1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {
            if (interval[0] > left && interval[1] >  right) {
                left = interval[0];
                result++;
            }
            right = Math.max(right, interval[1]);
        }
        return result;
    }
}