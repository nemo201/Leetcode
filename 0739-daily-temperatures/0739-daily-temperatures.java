class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int today = 0; today < n; today++) {
            while (!stack.isEmpty() && temperatures[today] > temperatures[stack.peek()]) {
                int dayWhereTempLowerThanToday = stack.pop();
                ans[dayWhereTempLowerThanToday] = today - dayWhereTempLowerThanToday;
            }
            stack.push(today);
        }

        return ans;
    }
}