class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        );

        int n = envelopes.length;
        List<Integer> tails = new ArrayList<>();
        for (int[] env : envelopes) {
            int height = env[1];
            int left = 0;
            int right = tails.size();

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (tails.get(mid) < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == tails.size()) {
                tails.add(height);
            } else {
                tails.set(left, height);
            }
        }
        return tails.size();
    }
}