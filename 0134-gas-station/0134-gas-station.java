class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int total = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (sumGas < 0) {
                start = i + 1;
                sumGas = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}