class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : matrix) {
            for (int col : row)
                list.add(col);
        }
        
        Collections.sort(list);
        return list.get(k - 1);
    }
}