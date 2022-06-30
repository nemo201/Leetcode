class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
         int sumGas = 0, gasCost = 0, start = 0, tank = 0;
        
        for (int i = 0; i < gas.size(); i++) {
            sumGas += gas[i];
            gasCost += cost[i];
            
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }

        }
        if (sumGas < gasCost)
            return -1;
        return start;
    }
};