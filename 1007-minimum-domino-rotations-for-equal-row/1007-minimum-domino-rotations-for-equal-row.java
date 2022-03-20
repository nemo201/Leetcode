class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }
}

// class Solution {
//     public int minDominoRotations(int[] tops, int[] bottoms) {
//         int[] cA = new int[7], cB = new int[7], same = new int[7];
        
//         int n = tops.length;
//         for (int i = 0; i < n ; i++) {
//             cA[tops[i]]++;
//             cB[bottoms[i]]++;
//             if (tops[i] == bottoms[i])
//                 same[tops[i]]++;
//         }
//         for (int i = 1; i < 7; i++) {
//             if (cA[i] + cB[i] - same[i] == n)
//                 return n - Math.max(cA[i], cB[i]);
//         }
//         return -1;
//     }
// }