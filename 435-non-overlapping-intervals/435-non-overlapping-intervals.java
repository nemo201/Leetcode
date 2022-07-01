class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int cnt = 0;
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {
                cnt++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            } else
                prevEnd = intervals[i][1];
        }
        
        return cnt;
    }
}