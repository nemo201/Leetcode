class Solution {
    	public int maxArea(int h, int w, int[] hc, int[] vc) {
        return (int) ((getMaxDist(h, hc) * getMaxDist(w, vc)) % 1000000007L);
    }
    
    private long getMaxDist(int end, int[] cuts) {
        Arrays.sort(cuts);
        long res = 0, from = 0;
        for (int c : cuts) {
            res = Math.max(res, c - from);
            from = c;
        }
        return Math.max(res, end - from);
    }
}