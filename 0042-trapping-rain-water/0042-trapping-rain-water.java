class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];
        leftHeight[0] = height[0];
        rightHeight[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            leftHeight[i] = Math.max(height[i], leftHeight[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(height[i], rightHeight[i + 1]); 
        }

        int[] minHeight = new int[n];
        for (int i = 0; i < n; i++) {
            minHeight[i] = Math.min(leftHeight[i], rightHeight[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] < minHeight[i]) {
                water += minHeight[i] - height[i];
            }
        }
        return water;
    }
}