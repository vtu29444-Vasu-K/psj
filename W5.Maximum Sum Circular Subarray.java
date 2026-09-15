public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxKadane = nums[0], currentMax = 0;
        int minKadane = nums[0], currentMin = 0;
        for (int x : nums) {
            totalSum += x;
            // Standard Kadane's for Maximum Subarray
            currentMax = Math.max(x, currentMax + x);
            maxKadane = Math.max(maxKadane, currentMax);
            // Kadane's logic for Minimum Subarray
            currentMin = Math.min(x, currentMin + x);
            minKadane = Math.min(minKadane, currentMin);
        }
        // If all elements are negative, maxKadane is the largest single element
        if (maxKadane < 0) {
            return maxKadane;
        }
        return Math.max(maxKadane, totalSum - minKadane);
    }
}
