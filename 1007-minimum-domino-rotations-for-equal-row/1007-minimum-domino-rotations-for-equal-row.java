class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] cA = new int[7], cB = new int[7], same = new int[7];
        
        int n = tops.length;
        for (int i = 0; i < n ; i++) {
            cA[tops[i]]++;
            cB[bottoms[i]]++;
            if (tops[i] == bottoms[i])
                same[tops[i]]++;
        }
        for (int i = 1; i < 7; i++) {
            if (cA[i] + cB[i] - same[i] == n)
                return n - Math.max(cA[i], cB[i]);
        }
        return -1;
    }
}