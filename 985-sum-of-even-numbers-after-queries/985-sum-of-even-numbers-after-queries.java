class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int s = 0;
        for (int x : A)
            if (x % 2 == 0)
                s += x;
        
        int[] ans = new int[A.length];
        
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0)
                s -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0)
                s += A[index];
            ans[i] = s;
        }
        return ans;
    }
}