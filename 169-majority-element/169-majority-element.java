class Solution {
    public int majorityElement(int[] nums) {
        int ans = 0, number = 0;
        for (int num : nums) {
            if (ans == 0)
                number = num;
            if (number == num)
                ans++;
            else
                ans--;
        }
        return number;
    }
}