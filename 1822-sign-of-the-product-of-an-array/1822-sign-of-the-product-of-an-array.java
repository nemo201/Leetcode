class Solution {
    public int arraySign(int[] nums) {
        boolean flag = true;
        
        for (int num : nums) {
            if (num == 0)
                return 0;
            if (num < 0)
                flag = !flag;
        }
        return flag == true ? 1 : -1;
    }
}