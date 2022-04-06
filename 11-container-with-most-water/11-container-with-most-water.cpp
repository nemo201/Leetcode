class Solution {
public:
    int maxArea(vector<int>& height) {
        int len = height.size();
        int left = 0, right = len - 1;
        int ma = min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] <= height[right])
                left++;
            else
                right--;
            
            ma = max(ma, min(height[left], height[right]) * (right - left));
        }
        return ma;
    }
};