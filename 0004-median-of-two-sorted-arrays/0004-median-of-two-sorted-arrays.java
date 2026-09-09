class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Lengths of the two arrays
        int m = nums1.length;
        int n = nums2.length;

        // Always binary-search the smaller array
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Search for partition position in nums1
        int left = 0;
        int right = m;

        while (left <= right) {

            // Try a partition in nums1
            int partitionA =
                left + (right - left) / 2;

            // Total number of elements required
            // on the left side
            //
            // partitionA + partitionB = (m+n+1)/2
            int partitionB =
                (m + n + 1) / 2 - partitionA;

            // Largest element on left of nums1
            int maxLeftA =
                (partitionA == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partitionA - 1];

            // Smallest element on right of nums1
            int minRightA =
                (partitionA == m)
                    ? Integer.MAX_VALUE
                    : nums1[partitionA];

            // Largest element on left of nums2
            int maxLeftB =
                (partitionB == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partitionB - 1];

            // Smallest element on right of nums2
            int minRightB =
                (partitionB == n)
                    ? Integer.MAX_VALUE
                    : nums2[partitionB];

            // Check if we found the correct partition
            if (maxLeftA <= minRightB &&
                maxLeftB <= minRightA) {

                // Odd number of total elements
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeftA, maxLeftB);
                }

                // Even number of total elements
                return (
                    Math.max(maxLeftA, maxLeftB)
                    +
                    Math.min(minRightA, minRightB)
                ) / 2.0;

            // A's partition is too far RIGHT
            } else if (maxLeftA > minRightB) {

                right = partitionA - 1;

            // A's partition is too far LEFT
            } else {

                left = partitionA + 1;
            }
        }

        return 0;
    }
}