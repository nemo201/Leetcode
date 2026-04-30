class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int target = k * threshold;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int count = 0;
        if (sum >= target) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];

            if (sum >= target) {
                count++;
            }
        }

        return count;
    }
}