class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = i; j < temp.length; j++) {
                if (temp[j] > temp[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}