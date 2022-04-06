class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] <= height[right])
                left++;
            else
                right--;
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }
        return max;
    }
}