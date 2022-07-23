class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int maxNum = 0;
        
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }
        
        int twoBack = 0;
        int oneBack = points.getOrDefault(1, 0);
        
        for (int num = 2; num <= maxNum; num++) {
            int temp = oneBack;
            oneBack = Math.max(oneBack, twoBack + points.getOrDefault(num, 0));
            twoBack = temp;
        }
        return oneBack;
    }
}

// bottom up
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         Map<Integer, Integer> points = new HashMap<>();
//         int maxNum = 0;
        
//         for (int num : nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//             maxNum = Math.max(maxNum, num);
//         }
        
//         int[] dp = new int[maxNum + 1];
//         dp[1] = points.getOrDefault(1, 0);
        
//         for (int num = 2; num < dp.length; num++) {
//             int gain = points.getOrDefault(num, 0);
//             dp[num] = Math.max(dp[num - 1], dp[num - 2] + gain);
//         }
//         return dp[maxNum];
//     }
// }

// top down
// class Solution {
//     private Map<Integer, Integer> points = new HashMap<>();
//     private Map<Integer, Integer> cache = new HashMap<>();
    
//     public int deleteAndEarn(int[] nums) {
//         int maxNum = 0;
//         for (int num : nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//             maxNum = Math.max(maxNum, num);
//         }
//         return maxPoints(maxNum);        
//     }
    
//     private int maxPoints(int num) {
//         if (num == 0)
//             return 0;
        
//         if (num == 1)
//             return points.getOrDefault(1, 0);
        
//         if (cache.containsKey(num))
//             return cache.get(num);
        
//         int gain = points.getOrDefault(num, 0);
//         cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
        
//         return cache.get(num);
//     }
// }