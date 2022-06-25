class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            
            if (max > result)
                result = max;
        }
        return result;
    }
}

// bruteforce
// class Solution {
//     public int maxProduct(int[] nums) {
//         int max = Integer.MIN_VALUE, pro = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             pro = 1;
//             for (int j = i; j < nums.length; j++) {
//                 pro *= nums[j];
//                 max = Math.max(max, pro);
//             }
//         }
//         return max;
//     }
// }