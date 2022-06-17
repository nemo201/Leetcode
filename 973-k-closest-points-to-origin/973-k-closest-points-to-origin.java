class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> sd(a) - sd(b));
        
        return Arrays.copyOf(points, k);
    }
    
    private int sd(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}