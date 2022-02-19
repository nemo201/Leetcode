class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length, mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1)
                num *= 2;
            pq.add(-num);
            mi = Math.min(mi,num);
        }
        
        while (true) {
            int a = -pq.poll();
            res = Math.min(res, a - mi);
            if (a % 2 == 1)
                break;
            mi = Math.min(mi, a / 2);
            pq.add(-a/ 2);
        }
        return res;
    }
}